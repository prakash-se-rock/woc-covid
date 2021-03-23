<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
<h3>Please select a theatre</h3>

<hr/>
	<div style="padding: 10px;">${covidcases.state.stateName}</div>
	<div style="padding: 10px;">${covidcases.totalCase}</div>
	<div style="padding: 10px;">${covidcases.activeCases}</div>
	<div style="padding: 10px;">${covidcases.recoverCases}</div>
	<div style="padding: 10px;">${covidcases.deathCases}</div>
</div>

<%@ include file="fragment/footer.jspf"%>