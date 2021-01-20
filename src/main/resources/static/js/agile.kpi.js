var agile_kpi_task = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
           _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

    },    
    save: function() {
        var data = {
            taskName: $('#taskName').val(),
            taskType: $('#taskType option:selected').val(),
            impactStatus: $('#impactStatus option:selected').val(),
            complexityStatus: $('#complexityStatus option:selected').val(),
            isFinished: $("input:checkbox[id='isFinished']").is(":checked"),
            periodId: $('input[name=period]').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/tasks',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error))
        });
    },

    update: function() {
        var data = {
            taskName: $('#taskName').val(),
            taskType: $('#taskType option:selected').val(),
            impactStatus: $('#impactStatus option:selected').val(),
            complexityStatus: $('#complexityStatus option:selected').val(),
            isFinished: $("input:checkbox[id='isFinished']").is(":checked")
        };

        var id = $('input[name=taskId]').val()

        $.ajax({
            type: 'PUT',
            url: '/api/tasks/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error))
        });
    },

    delete: function() {
        var id = $('input[name=taskId]').val()

        $.ajax({
            type: 'DELETE',
            url: '/api/tasks/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error))
        });
    }

}

agile_kpi_task.init();

// ============================================================

var agile_kpi_period = {
    init : function () {
        var _this = this;
        // $('#createKpi').on('click', function () {
        //     _this.create();
        //  });
        $('#btn-period-save').on('click', function () {
           _this.save();
           return false;
        });
    },
    // create: function() {
    //     var form = "";
    //     form += "<form>";
    //     form += "<p><input type='text' name='fromDate' id='from_datepicker' placeholder='From'></p>";
    //     form += "<p><input type='text' name='toDate' id='to_datepicker' placeholder='To'></p>";
    //     form += "<button class='btn btn-kpi' id='btn-kpi-save'>Save</button>";
    //     form += "<button class='btn btn-kpi-sub' id='btn-kpi-cancel'>Cancel</button>";
    //     form += "</form>";
    //     $( "#period-set" ).append(form);
    // },

    save: function() {
        var data = {
            fromDate: $( "#from_datepicker" ).val(),
            toDate: $( "#to_datepicker" ).val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/period',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            //window.location.href = '/';
            location.reload();
        }).fail(function(error){
            alert(JSON.stringify(error))
        });
    }
}

agile_kpi_period.init();


