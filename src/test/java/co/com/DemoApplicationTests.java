package co.com;

import co.com.commands.CentralCommand;
import co.com.domain.TypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DemoApplicationTests {

	private CentralCommand centralCommand;

	@BeforeEach
	public void startData() {
		centralCommand = new CentralCommand();
	}

	@Test
	void contextLoadsValidTest() {
		centralCommand.executeMain("[({})]");
		assertTrue(true);
	}

	@Test
	void contextLoadsInvalidTest() {
		TypeException exception = assertThrows(TypeException.class, () -> {
			centralCommand.executeMain("[({}[)]");
		});

		assertNotNull(exception);
	}
}