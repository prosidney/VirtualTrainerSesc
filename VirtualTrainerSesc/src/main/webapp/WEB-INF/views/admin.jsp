<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<layout:page title="VirtualTrainerSesc" description="Home" keywords="amazing, app, VirtualTrainerSesc" user="Admin">
    <jsp:body>
        <center>
			<table class="table table-hover" style="width: 50%">
				<tr>
					<th colspan="7" style="text-align: center;" style="width: 80%"><c:out value="Alunos" /></th>
				</tr>
				<tr>
					<th><c:out value="Matricula" /></th>
					<th><c:out value="Nome" /></th>
					<th><c:out value="Idade" /></th>
					<th><c:out value="Peso" /></th>
					<th><c:out value="Ações" /></th>
				</tr>
				<c:forEach var="aluno" items="${alunos}">
					<tr>
						<td style="width: 5%"><c:out value="${aluno.matricula}" /></td>
						<td><c:out value="${aluno.nome}" /></td>
						<td><c:out value="${aluno.idade}" /></td>
						<td><c:out value="${aluno.peso} Kg" /></td>
						<td>
							<a class="btn btn-primary" href="<c:url value="admin/${aluno.matricula}/treinos"/>"><i class="icon-user icon-white"></i> </a>						
						</td>
					</tr>
				</c:forEach>
			</table>
		</center>        
    </jsp:body>
</layout:page>