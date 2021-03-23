<%@ include file="fragment/header.jspf"%>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> 


<h1>My Web Page</h1>

<table>
  <tr>
      <th><div id="piechart"></div></th>
      <th><div id="barchart"></div></th>
    </tr>
</table>
<table style="margin-left: 200px;" id = "datatable">
  <caption>India Covid 19 Cases State wise</caption>
  <thead>
    <tr>
      <th><div style="padding:10px;">State</div></th>
      <th><div style="padding: 10px;">Total Cases</div></th>
      <th><div style="padding: 10px;">Active Cases</div></th>
      <th><div style="padding: 10px;color: green;">Recover Cases</div></th>
      <th><div style="padding: 10px;color: red;">Death Cases</div></th>
    </tr>
  </thead>
<c:forEach items="${covidallcases}" var="covidcase" varStatus="loop">
  <tbody>
    <tr>
  	  <th><div style="padding:10px;" id="state${loop.index}"><a href="/covidcases/state/${covidcase.state.stateCode}">${covidcase.state.stateName}</a></div></th>
      <th><div style="padding: 10px;" id="totalCase${loop.index}">${covidcase.totalCase}</div></th>
      <th><div style="padding: 10px;" id="activeCase${loop.index}">${covidcase.activeCases}</div></th>
      <th><div style="padding: 10px;color: green" id="recoverCase${loop.index}">${covidcase.recoverCases}</div></th>
      <th><div style="padding: 10px;color: red;" id="deathCase${loop.index}">${covidcase.deathCases}</div></th>
    </tr> 
   </tbody> 
</c:forEach>
<tfoot>
    <tr>
      <td colspan="4"><em>All data is share by Govt Of India recently</em></td>
    </tr>
  </tfoot>
</table>	

<script type="text/javascript">
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);
  function drawChart(data) {
  	try {
  		 var data = google.visualization.arrayToDataTable([
  			  ['Task', 'Death Cases'], // we can construct this data using loop for (var i=0;i<states.length;i++) { ['document.getElementById('state$i')' , 'document.getElementById('recoverCase$i')'] }
  			  ['AN', 100],
  			  ['AD', 10],
  			  ['AR', 100],
  			  ['AS', 20],
  			  ['AP', 510],
  			  ['BH', 810],
  			  ['CH', 110],
  			  ['CT', 50],
  			  ['DN', 90],
  			  ['DD', 70],
  			  ['DL', 1002],
  			  ['GA', 5000],
  			  ['GJ', 7000],
  			  ['HR', 2000],
  			  ['HP', 505],
  			  ['JK', 102],
  			  ['JH', 20],
  			  ['KA', 1009],
  			  ['KL', 10001],
  			  ['LD', 10],
  			  ['MP', 567],
  			  ['MH', 8900],
  			  ['MN', 102],
  			  ['ME', 103],
  			  ['MI', 678],
  			  ['NL', 805],
  			  ['OR', 503],
  			  ['PY', 500],
  			  ['PB', 200],
  			  ['RJ', 500],
  			  ['SK', 534],
  			  ['TN', 24],
  			  ['TS', 44],
  			  ['TR', 45],
  			  ['UP', 700],
  			  ['UT', 5644],
  			  ['WB', 1011]
  			]);
  	} catch(e) {
  		 console.log(e);
  	}
   
    // Optional; add a title and set the width and height of the chart
    var options = {'title':'Total Death Case By State', 'width':550, 'height':400};

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    chart.draw(data, options);
}

//-------------
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart1);
function drawChart1(data) {
	try {
		 var data = google.visualization.arrayToDataTable([
			  ['Task', 'Active Cases'],// we can construct this data using loop for (var i=0;i<states.length;i++) { ['document.getElementById('state$i')' , 'document.getElementById('activeCase$i')'] }
			  ['AN', 100010],
			  ['AD', 201010],
			  ['AR', 3005010],
			  ['AS', 400710],
			  ['AP', 507010],
			  ['BH', 600810],
			  ['CH', 730010],
			  ['CT', 808010],
			  ['DN', 909010],
			  ['DD', 10002010],
			  ['DL', 110003410],
			  ['GA', 120001034],
			  ['GJ', 1300010767],
			  ['HR', 14000560],
			  ['HP', 15003401],
			  ['JK', 16005610],
			  ['JH', 17004310],
			  ['KA', 18007810],
			  ['KL', 100310],
			  ['LD', 205010],
			  ['MP', 2180010],
			  ['MH', 2260010],
			  ['MN', 2300910],
			  ['ME', 2480610],
			  ['MI', 2500010],
			  ['NL', 2630010],
			  ['OR', 270010],
			  ['PY', 281010],
			  ['PB', 293010],
			  ['RJ', 308010],
			  ['SK', 312010],
			  ['TN', 3200710],
			  ['TS', 33097710],
			  ['TR', 3409890],
			  ['UP', 35067810],
			  ['UT', 3609010],
			  ['WB', 3707910]
			]);
	} catch(e) {
		 console.log(e);
	}
 
  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Total Active Case By State', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.BarChart(document.getElementById('barchart'));
  chart.draw(data, options);
}
</script> 

<%@ include file="fragment/footer.jspf"%>
