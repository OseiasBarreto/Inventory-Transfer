package inventorytransfer;


import inventorytransfer.model.Stock;
import inventorytransfer.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventorytransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorytransferApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(StockRepository stockRepository) {
		return args -> {
			if (stockRepository.count() == 0) {
				Stock estoque1 = new Stock();
				estoque1.setName("Armazém Central");
				estoque1.setQuantity(100);

				Stock estoque2 = new Stock();
				estoque2.setName("Filial Norte");
				estoque2.setQuantity(50);

				stockRepository.save(estoque1);
				stockRepository.save(estoque2);

				System.out.println("✅ Estoques iniciais criados!");
			}
		};
	}
}

