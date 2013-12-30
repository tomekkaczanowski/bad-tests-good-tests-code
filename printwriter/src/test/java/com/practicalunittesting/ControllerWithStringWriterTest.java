package com.practicalunittesting;

import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

public class ControllerWithStringWriterTest {

	HttpServletRequest req = mock(HttpServletRequest.class);
	HttpServletResponse resp = mock(HttpServletResponse.class);
	ReportService reportService = mock(ReportService.class);

	ReportController ctrl = new ReportController(reportService);

	@Test
	public void shouldWriteReportData() throws IOException {
		// given
		ReportData dataPl = new ReportData(1, 2, 1.5);
		ReportData dataFr = new ReportData(3, 4, 0.12345);

		Writer stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		given(resp.getWriter()).willReturn(writer);
		given(reportService.getReportData(any(Filter.class)))
				.willReturn(Arrays.asList(dataPl, dataFr));

		// when
		ctrl.generateReport(req,  resp);

		// then
		assertThat(stringWriter.toString())
				.isEqualTo("min,max,avg\n1,2,1.5\n3,4,0.12345\n");
	}
}
