function surveyResults(info){
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Answer');
    data.addColumn('number', 'Amount');
    data.addRows(info);
    var options = {
        'title': 'Survey Result Spread',
        'width': 1000,
        'height': 1000
    };
    var chart = new google.visualization.PieChart(document.getElementById('answerSpread'));
    chart.draw(data, options);
}

function loadChat(callback) {
    $(document).ready(function() {
        $.ajax({
            url: "/questions/2"
        }).then(function (data) {
            var answers = data.questionType;
            var count1 = getCount(answers.answer1, data.answers);
            var count2 = getCount(answers.answer2, data.answers);
            var count3 = getCount(answers.answer3, data.answers);
            var count4 = getCount(answers.answer4, data.answers);
            var info = [
                [answers.answer1, count1],
                [answers.answer2, count2],
                [answers.answer3, count3],
                [answers.answer4, count4],
            ]
            console.log(info);
            callback(info);
        });
    });
}
function getCount(answer1, data) {
    var count = 0;
    for (var i = 0; i < data.length; i++) {
        if (data[i].answer.trim() === answer1) {
            count++;
        }
    }
    return count;
}
loadChat(load);
google.charts.load('current', {'packages':['corechart']});

function load(info){
    google.charts.load(surveyResults(info));
}
