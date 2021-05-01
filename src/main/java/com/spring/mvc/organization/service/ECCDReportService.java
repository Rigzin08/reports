package com.spring.mvc.organization.service;

import com.spring.mvc.enumeration.ReportType;
import com.spring.mvc.helper.BaseService;
import com.spring.mvc.integration.birt.report.domain.dto.ReportRequestDto;
import com.spring.mvc.integration.birt.report.domain.dto.ReportResponseDto;
import com.spring.mvc.integration.birt.report.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;


@Service
public class ECCDReportService extends BaseService {

    @Transactional
    public ReportResponseDto generateReport(String reportFormat, Map<String, Object> params, String reportPath,
                                            String outputPath,  Integer reportType) throws
            JRException, ClassNotFoundException, SQLException, ParseException {

        Connection connection = ((SessionImpl) getCurrentSession()).connection();

        String headerName = "";
        String footerName = "";
        String reportName = "";
        String reportJRXML = "";
        reportPath = reportPath.replace("\\", "/");

        final String callLogReport = "/document/eccdReport.jrxml";
//        final String example = "/document/example.jrxml";
//        final String example1 = "/document/example1.jrxml";

        if (reportType.equals(ReportType.ECCD_REPORT.getValue())) {
            reportJRXML = callLogReport;
            params.put("reportTitle", "ECCD Report");
            reportName = "ECCD Report";
        }
//        if (reportType.equals(ReportType.ECCD2_REPORT.getValue())) {
//            reportJRXML = exampleReport;
//            params.put("reportTitle", "Report");
//            reportName = "Example Report";
//        }
//        if (reportType.equals(ReportType.ECCD3_REPORT.getValue())) {
//            reportJRXML = exampleReport1;
//            params.put("reportTitle", "Report");
//            reportName = "Example Report1 Report";
//        }

        headerName = ReportService.portraitHeaderName;
        footerName = ReportService.portraitFooterName;

        ReportRequestDto reportRequestDto = new ReportRequestDto(outputPath, reportName, reportFormat,
                reportPath + headerName, reportPath + reportJRXML, reportPath + footerName,
                reportPath, params, connection);

        return ReportService.createReport(reportRequestDto);
    }

}
