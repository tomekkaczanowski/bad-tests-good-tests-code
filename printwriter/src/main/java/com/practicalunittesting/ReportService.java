package com.practicalunittesting;

import java.util.List;

public interface ReportService {
	List<ReportData> getReportData(Filter filter);
}
