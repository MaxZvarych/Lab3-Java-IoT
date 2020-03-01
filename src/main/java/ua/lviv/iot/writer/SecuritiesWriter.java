package ua.lviv.iot.writer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.model.Securities;

public class SecuritiesWriter {
	public Writer csvWriter = new StringWriter();

	public Writer getCsvWriter() {
		return csvWriter;
	}

	public void setCsvWriter(Writer csvWriter) {
		this.csvWriter = csvWriter;
	}

	public void writeToFile(List<Securities> listOfSecurities) throws IOException {
		for (Securities securities : listOfSecurities) {
			csvWriter.write(securities.getHeaders() + "," + securities.toCSV());
			csvWriter.write("\n");
		}
		csvWriter.flush();
	}

	@Override
	public String toString() {
		return csvWriter.toString();
	}
}
