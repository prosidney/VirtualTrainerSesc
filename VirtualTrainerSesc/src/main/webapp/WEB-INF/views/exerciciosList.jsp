<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="VirtualTrainerSesc" description="Home" keywords="amazing, app, VirtualTrainerSesc" user="Admin">
    <jsp:body>
        <center>
			<table class="table table-hover" style="width: 50%">
				<tr>
					<th colspan="7" style="text-align: center;" style="width: 80%"><c:out value="Exercicios do ${treino.nome}" /></th>
				</tr>
				<tr>
					<th><c:out value="Equipamento" /></th>
					<th><c:out value="Execucao" /></th>
					<th><c:out value="Musculatura" /></th>
					<th><c:out value="Qualidade" /></th>
					<th><c:out value="Ações" /></th>
				</tr>
				<c:forEach var="exercicio" items="${exercicios}">
					<tr>
						<td style="width: 5%"><c:out value="${exercicio.equipamento}" /></td>
						<td><c:out value="${exercicio.execucao}" /></td>
						<td><c:out value="${exercicio.musculatura}" /></td>
						<td><c:out value="${exercicio.qualidade}" /></td>
						<td>
							<a class="btn btn-primary" href="#" onclick="window.alert('Trial version')"><i class="icon-edit icon-white"></i></a>						
						</td>
					</tr>
				</c:forEach>
			</table>
			<a class="btn btn-primary" href="<c:url value="${treino.id}/add"/>"><i class="icon-plus-sign icon-white"></i> </a>
		</center>        
    </jsp:body>
</layout:page>