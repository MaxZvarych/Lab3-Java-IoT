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
		for (Securities listOfSecurities : securities) {
			expected.append(listOfSecurities.getHeaders()).append(",").append(listOfSecurities.toCSV()).append("\n");
		}
		assertEquals(expected.toString(), securitiesWriter.toString());

	}
}
