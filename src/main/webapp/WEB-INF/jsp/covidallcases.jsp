<%@ include file="fragment/header.jspf"%>

<div style="text-align:center">
<h3>Covid 19 State wise cases</h3>

<hr/>

<c:forEach items="${covidallcases}" var="covidcase">
    <div style="padding:10px;"><a href="/covidcases/state/${covidcase.state.stateCode}" >${covidcase.state.stateName}</a></div>
    <div style="padding: 10px;">${covidcase.totalCase}</div>
	<div style="padding: 10px;">${covidcase.activeCases}</div>
	<div style="padding: 10px;">${covidcase.recoverCases}</div>
	<div style="padding: 10px;">${covidcase.deathCases}</div>
</c:forEach>

</div>

<%@ include file="fragment/footer.jspf"%>ile="fragment/footer.jspf"%>