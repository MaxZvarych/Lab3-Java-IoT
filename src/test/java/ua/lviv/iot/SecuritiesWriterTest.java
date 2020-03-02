package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.model.Securities;
import ua.lviv.iot.writer.SecuritiesWriter;

class SecuritiesWriterTest extends BaseSecuritiesManager {
	SecuritiesWriter securitiesWriter = new SecuritiesWriter();

	@Test
	void writeToFileTest() throws IOException {
		Writer csvWriter = new FileWriter("info.csv");
		securitiesWriter.setCsvWriter(csvWriter);
		securitiesWriter.writeToFile(securities);
	}

	@Test
	void stringWriterTest() throws IOException {
		StringBuilder expected = new StringBuilder();
		securitiesWriter.setCsvWriter(new StringWriter());
		securitiesWriter.writeToFile(securities);
		expected.append(securities.get(0).getHeaders());
		expected.append("\n");
		for (Securities listOfSecurities : securities) {
			expected.append(listOfSecurities.toCSV());
			expected.append("\n");
		}
		assertEquals(expected.toString(), securitiesWriter.toString());

	}
}
