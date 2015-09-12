var Files = Java.type('java.nio.file.Files')
var Paths = Java.type('java.nio.file.Paths')
var JString = Java.type('java.lang.String')
var ObservableList = Java.type('javafx.collections.ObservableList')
var FXCollections = Java.type('javafx.collections.FXCollections')
var PieChart = Java.type('javafx.scene.chart.PieChart')
var PieChart_Data = Java.type('javafx.scene.chart.PieChart$Data')
var Scene = Java.type('javafx.scene.Scene')
    
function loadPieData(path){
    var text = new JString(Files.readAllBytes(path), 'utf-8');
    return JSON.parse(text);
}

var pieData = FXCollections.observableArrayList();
var pieKeyValues = loadPieData(Paths.get('./out/pie.json'))
for(var key in pieKeyValues){
    pieData.add(new PieChart_Data(key, parseFloat(pieKeyValues[key])));
}
var pieChart = new PieChart(pieData);
pieChart.title = 'Title';
var scene = new Scene(pieChart);
$STAGE.scene = scene;
$STAGE.show();