var agile_kpi = {
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
            kpiId: $('input[name=kpi]').val()
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

agile_kpi.init();
