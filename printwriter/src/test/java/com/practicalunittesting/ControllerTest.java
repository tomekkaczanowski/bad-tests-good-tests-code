package com.practicalunittesting;

import org.mockito.InOrder;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerTest {

	HttpServletRequest req = mock(HttpServletRequest.class);
	HttpServletResponse resp = mock(HttpServletResponse.class);
	ReportService reportService = mock(ReportService.class);
	PrintWriter writer = mock(PrintWriter.class);

	ReportController ctrl = new ReportController(reportService);

	@Test
	public void shouldWriteReportData() throws IOException {
		// given
		ReportData dataPl = new ReportData(1, 2, 1.5);
		ReportData dataFr = new ReportData(3, 4, 0.12345);

		given(resp.getWriter()).willReturn(writer);
		given(reportService.getReportData(any(Filter.class)))
				.willReturn(Arrays.asList(dataPl, dataFr));

		// when
		ctrl.generateReport(req,  resp);

		// then
		InOrder inOrder = Mockito.inOrder(writer);
		inOrder.verify(writer).append("min,max,avg\n");

		inOrder.verify(writer).append(String.valueOf(1));
		inOrder.verify(writer).append(",");
		inOrder.verify(writer).append(String.valueOf(2));
		inOrder.verify(writer).append(",");
		inOrder.verify(writer).append(String.valueOf(1.5));
		inOrder.verify(writer).append("\n");
		inOrder.verify(writer).append(String.valueOf(3));
		inOrder.verify(writer).append(",");
		inOrder.verify(writer).append(String.valueOf(4));
		inOrder.verify(writer).append(",");
		inOrder.verify(writer).append(String.valueOf(0.12345));
		inOrder.verify(writer).append("\n");
	}
}
