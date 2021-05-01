
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<%--    <title>Title</title>--%>
</head>
<body>
<section class="content">
    <div class="container-fluid">
        <div class="card card-info">
            <div class="card-body">
                <form id="generateReportForm" action="" class="form-horizontal globalForm">
                    <fieldset>
                        <legend>Organization Report</legend>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label text-sm">Report Type:</label>
                                <div class="col-md-4">
                                    <input type="radio" name="report" class="" id="report1"
                                           value="0" checked/>
                                    <label for="report1"/>ECCD</label>&nbsp;&nbsp;

                                    <input type="radio" name="report" class="" id="report2"
                                           value="1" />
                                    <label for="report2"/>School List</label>&nbsp;&nbsp;
                                    <input type="radio" name="report" class="" id="report3"
                                           value="2" />
                                    <label for="report3"/>Report3</label>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label text-sm">Category</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control form-control-sm" name="category" id="category" required="true">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label text-sm">Report Format : </label>
                                <div class="col-md-4">

                                    <input type="radio" name="reportFormat" id="html" value="html" checked/>
                                    <label for="html" class="col-form-label text-sm"/>Html</label>&nbsp;&nbsp;

                                    <input type="radio" name="reportFormat" id="xls" value="xls"/>
                                    <label for="xls" class="col-form-label text-sm"/>XLS</label>&nbsp;&nbsp;

                                    <input type="radio" name="reportFormat" class="pdf" id="pdf" value="pdf"/>
                                    <label for="pdf" class="col-form-label text-sm"/>PDF</label>&nbsp;&nbsp;

                                    <input type="radio" name="reportFormat" id="docx" value="docx"/>
                                    <label for="docx" class="col-form-label text-sm"/>DOCx</label>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2"></div>
                                <div class="col-md-2">
                                    <input type="button" id="generateReport" value="Generate" class="btn btn-primary btn-block"/>
                                </div>
                            </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
