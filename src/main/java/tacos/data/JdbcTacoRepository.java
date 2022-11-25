package tacos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import tacos.Taco;
import tacos.Ingredient;

@Repository
public class JdbcTacoRepository implements TacoRepository{
	
	private JdbcTemplate jdbc;
	private IngredientRepository ingredientRepo;
	
	public JdbcTacoRepository(JdbcTemplate jdbc, IngredientRepository ingredientRepo) {
		this.jdbc = jdbc;
		this.ingredientRepo = ingredientRepo;
	}

	@Override
	public Taco save(Taco taco) {
		long tacoId = saveTacoInfo(taco);
		taco.setId(tacoId);
		for (String ingr : taco.getIngredients()) {
			Ingredient ingredient = ingredientRepo.findOne(ingr);
			saveIngredientToTaco(ingredient, tacoId);
		}
		return taco;
	}
	
	private long saveTacoInfo(Taco taco) {
		taco.setCreatedAt(new Date());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement("insert into Taco (name, createdAt) values (?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, taco.getName());
                pstmt.setTimestamp(2, new Timestamp(taco.getCreatedAt().getTime()));
                return pstmt;
            }
        }, keyHolder);
		return keyHolder.getKey().longValue();
		}
	
	private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
		jdbc.update("insert into Taco_Ingredients (taco, ingredient) values (?, ?)",
														tacoId, ingredient.getId());
		}

}
