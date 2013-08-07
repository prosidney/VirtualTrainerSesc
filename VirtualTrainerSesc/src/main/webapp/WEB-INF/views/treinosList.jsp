<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="VirtualTrainerSesc" description="Home" keywords="amazing, app, VirtualTrainerSesc" user="Admin">
    <jsp:body>
        <center>
			<table class="table table-hover" style="width: 80%">
				<tr>
					<th colspan="7" style="text-align: center;" style="width: 80%"><c:out value="Treinos do ${aluno.nome}" /></th>
				</tr>
				<tr>
					<th><c:out value="Nome" /></th>
					<th><c:out value="Qtde Realizado" /></th>
					<th><c:out value="Qtde Total" /></th>
					<th><c:out value="Ações" /></th>
				</tr>
				<c:forEach var="treino" items="${aluno.treinos}">
					<tr>
						<td><c:out value="${treino.nome}" /></td>
						<td><c:out value="${treino.qtde}" /></td>
						<td><c:out value="${treino.qtdeTotal}" /></td>
						<td>
							<c:choose> 
								<c:when test="${treino.qtde < treino.qtdeTotal}">
									<div class="progress progress-striped active" style="min-width: 200px;">
									  <!-- <div class="bar" style="width: "75%;"></div> -->
									  <div class="bar" style="<c:out value="width: ${treino.porcetagemConcluido}%;"/>"></div>
									</div>								  	
								</c:when> 
								<c:otherwise> 
									<div class="progress progress-striped" style="min-width: 200px;">
									  <div class="bar" style="width: 100%;"></div>
									</div>						  	
								</c:otherwise>	
							</c:choose> 
						</td>
						<td>
							<a class="btn btn-primary" href="<c:url value="treinos/${treino.id}"/>"><i class="icon-th-list icon-white"></i></a>
							<a class="btn btn-primary" href="#" onclick="window.alert('Trial version')"><i class="icon-edit icon-white"></i></a>						
						</td>
					</tr>
				</c:forEach>
			</table>
			<a class="btn btn-primary" href="<c:url value="treinos/add"/>"><i class="icon-plus-sign icon-white"></i> </a>
		</center>        
    </jsp:body>
</layout:page>