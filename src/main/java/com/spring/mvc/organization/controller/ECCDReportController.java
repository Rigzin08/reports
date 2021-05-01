package com.spring.mvc.organization.controller;

import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.BaseController;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.integration.birt.report.domain.dto.ReportResponseDto;
import com.spring.mvc.organization.service.ECCDReportService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/eccdReport")
public class ECCDReportController extends BaseController {

    private ECCDReportService eccdReportService;

    public ECCDReportController(ECCDReportService eccdReportService) {
        this.eccdReportService = eccdReportService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(HttpServletRequest request, Model model) {
        return "eccdReport";
    }

    @ResponseBody
    @RequestMapping(value = "/generateReport", method = {RequestMethod.GET})
    public ResponseMessage generateReport(HttpServletRequest request, Integer reportType
            , String reportFormat, Integer categoryId) {
        ResponseMessage responseMessage = new ResponseMessage();
//        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("reportType", reportType);
        params.put("categoryId", categoryId);

        String reportSourcePath = getReportSourcePath(request);
        String reportOutputPath = getReportOutputPath(request);

        List<ReportResponseDto> reportResponseDtos = new ArrayList<>();
        try {
            ReportResponseDto reportResponseDto = eccdReportService.generateReport(reportFormat, params,
                    reportSourcePath, reportOutputPath, reportType);
            reportResponseDtos.add(reportResponseDto);
        } catch (Exception ex) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Report generation failed. " + ex);
        }
        responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setResponseDTO(reportResponseDtos);
        return responseMessage;
    }
}
