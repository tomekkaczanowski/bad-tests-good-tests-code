package com.practicalunittesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ReportController {

	private final ReportService reportService;

	@Autowired
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}

	public void generateReport(HttpServletRequest request,
							   HttpServletResponse response) throws IOException {
		Filter filter = parseRequest(request);
		List<ReportData> reportData = reportService.getReportData(filter);
		PrintWriter writer = response.getWriter();
		writeHeaders(writer);
		for (ReportData data : reportData) {
			writer.append(String.valueOf(data.getMin()));
			writer.append(",");
			writer.append(String.valueOf(data.getMax()));
			writer.append(",");
			writer.append(String.valueOf(data.getAvg()));
			writer.append("\n");
		}
	}

	private void writeHeaders(PrintWriter writer) {
		writer.append("min,max,avg\n");
	}

	private Filter parseRequest(HttpServletRequest request) {
		return new Filter() {};
	}
}
