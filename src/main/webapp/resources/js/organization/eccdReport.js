eccdReport = (function () {

        function _baseURL() {
            return 'eccdReport/';
        }

        /**
         * method to generate report
         */
        function generateReport() {
            $('#generateReport').on('click', function () {

                let reportType = $("#report1").prop("checked") ? 0 : ($("#report2").prop("checked") ? 1 : 2);
                let reportFormat = $("#html").prop("checked") ? $("#html").val() : $("#xls").prop("checked") ? $("#xls").val() : ($("#pdf").prop("checked") ? $("#pdf").val() : $("#docx").val());
                let categoryId = $('#category').val();
                $.ajax({
                    url: _baseURL() + 'generateReport',
                    type: 'GET',
                    data: {
                        reportType: reportType,
                        categoryId: categoryId,
                        reportFormat: reportFormat,
                    },
                    async: false,
                    success: function (res) {
                        for (let i = 0; i < res.responseDTO.length; i++) {
                            window.open(moeGlobal.baseReportLocation() + res.responseDTO[i].reportName, '_blank');
                        }
                    }
                });
            })
        }

        return {
            generateReport: generateReport,
        }
    }
)();
$(document).ready(function () {
    eccdReport.generateReport();
});