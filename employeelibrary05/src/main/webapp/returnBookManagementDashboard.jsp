<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  --%>
<%-- <c:set var="serverContext" value="${pageContext.request.contextPath}" /> --%>
<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!--     <head> -->
<!--         <title>Return Management Dashboard</title>  -->
<%--         <%@include file="../common/header.jsp"%>  --%>
<!--     </head> -->
<!--     <body class="sb-nav-fixed"> -->
<%--     	<%@include file="../common/navbar.jsp"%>   --%>
<!--         <div id="layoutSidenav"> -->
<%--         	<%@include file="../common/sidebar.jsp"%>  --%>
<!--             <div id="layoutSidenav_content"> -->
<!--                 <main> -->
<!--                     <div class="container-fluid px-4"> -->
<!--                         <h3 class="mt-4">Return Book Management</h3> -->
<!--                         <ol class="breadcrumb mb-4"> -->
<!--                             <li class="breadcrumb-item ">Return Book</li> -->
<!--                             <li class="breadcrumb-item active">Return Books Management</li> -->
<!--                         </ol>  -->
<!-- <!--                   ============================================================== --> -->
<!-- <!--                   					   Modal START  								--> -->
<!-- <!--                   ============================================================== -->                          -->
               
<!--                <div class="modal fade" id="addReturnModal"> -->
<!-- 				  <div class="modal-dialog"> -->
<!-- 				    <div class="modal-content">   -->
<!-- 				      <div class="modal-header"> -->
<!-- 				        <h2 class="modal-title">Add Return Book Record</h2> -->
<!-- 				        <button type="button" class="btn-close" data-bs-dismiss="modal"></button> -->
<!-- 				      </div>   -->
<!-- 				      <div class="modal-body"> -->
<%-- 				        <form:form class="row g-3" action="saveLoanObject" modelAttribute="loan" method="POST"> --%>
<!-- 						  <div class="col-md-12"> -->
<!-- 						    <label for="id" class="form-label">ID</label> -->
<%-- 						    <form:input type="number" class="form-control" id="id" path="id" readonly="true"/>  --%>
<!-- 						  </div> -->
<!-- 						  <div class="col-md-12"> -->
<!-- 						    <label for="book" class="form-label">Book</label> -->
<%-- 							<form:select id="book" path="book" class="form-control">  --%>
<%-- 								<form:option selected="selected" disabled="disabled" value="">Choose Book</form:option> --%>
<%-- 								<c:forEach items="${books}" var="book"> --%>
<%-- 									<option value="${book.id}">${ book.name }</option> --%>
<%-- 								</c:forEach>  --%>
<%-- 							</form:select> --%>
<!-- 						</div>  -->
<!-- 						<div class="col-md-12"> -->
<!-- 						    <label for="employee" class="form-label">Employee</label> -->
<%-- 							<form:select id="employee" path="employee" class="form-control">  --%>
<%-- 								<form:option selected="selected" disabled="disabled" value="">Choose Employee</form:option> --%>
<%-- 								<c:forEach items="${employees}" var="employee"> --%>
<%-- 									<option value="${employee.id}" id="${ employee.name }">${ employee.name }</option> --%>
<%-- 								</c:forEach>  --%>
<%-- 							</form:select> --%>
<!-- 						</div>  -->
<!-- 						  <div class="col-md-6"> -->
<!-- 						    <label for="loand_date" class="form-label">Loand Date</label>  -->
<%-- 								<form:input type="date" class="form-control" id="loand_date" path="loand_date" readonly="true"/> --%>
<!-- 						  </div> -->
<!-- 						  <div class="col-md-6"> -->
<!-- 						    <label for="due_date" class="form-label">Due Date</label> -->
<%-- 						    <form:input type="date" class="form-control" id="due_date" path="due_date" readonly="true"/> --%>
<!-- 						  </div>  -->
<!-- 						  <div class="col-md-12"> -->
<!-- 						    <label for="returned_date" class="form-label">Returned Date</label> -->
<%-- 						    <form:input type="date" class="form-control" id="returned_date" path="returned_date"/> --%>
<!-- 						  </div>  -->
<!-- 						  <div class="col-md-12"> -->
<!-- 						    <label for="fine" class="form-label">Fine</label>  -->
<%-- 								<form:input type="number" class="form-control" id="fine" path="fine" /> --%>
<!-- 						  </div> -->
<!-- 						  <div class="col-md-12 text-center"> -->
<!-- 						      <button class="btn btn-primary w-100" type="submit">Return &amp; Pay Fine</button> -->
<!-- 						  </div>  -->
<%-- 						</form:form> --%>
<!-- 				      </div>    -->
<!-- 				    </div> -->
<!-- 				  </div> -->
<!-- 				</div>  -->
                
                
<!-- <!--                   ============================================================== --> -->
<!-- <!--                   					   Modal START  								--> -->
<!-- <!--                   ============================================================== -->            -->


<!-- <!--                        <div class="card mt-4"> --> -->
<!-- <!--                            <div class="card-header"> --> -->
<!-- <!--                                <i class="fas fa-table me-1"></i> --> -->
<!-- <!--                                DataTable Example --> -->
<!-- <!--                            </div>  --> -->
<!-- <!--                            <div class="card-body">  --> -->
<!-- 							<div class="mt-4"> -->
<!-- 								<table id="datatable-buttons" class="table table-striped table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;"> -->
<!--                                 	<thead> -->
<!--                                     	<tr> -->
<!-- 	                                     	<th>#</th>  -->
<!-- 	                                        <th>ID</th> -->
<!-- 	                                        <th>Book Id</th>  -->
<!-- 	                                        <th>Book Name</th>  -->
<!-- 											<th>Employee Name</th> -->
<!-- 											<th>Loand Date</th> -->
<!-- 											<th>Due Date</th> -->
<!-- 											<th>Returned Date</th> -->
<!-- 											<th>Fine</th> -->
<!-- 											<th>Edit</th> -->
<!--                                         </tr> -->
<!--                                      </thead>   -->
<!--                                      <tbody> -->
<%--                                         <c:set var="count" value="0" scope="page" /> --%>
<%-- 										<c:forEach varStatus="loopCounter" items="${loanList}" var="loan"> --%>
<%-- 											<c:choose> --%>
<%-- 												<c:when test="${not empty loan }"> --%>
<!-- 													<tr> -->
<%-- 														<c:set var="count" value="${count + 1}" scope="page" /> --%>
<%-- 														<td><c:out value="${count}"></c:out></td>  --%>
<%-- 														<td><c:out value="${loan.id}"></c:out></td> --%>
<%-- 														<td><c:out value="${loan.book.id}"></c:out></td>  --%>
<%-- 														<td><c:out value="${loan.book.name}"></c:out></td>  --%>
<%-- 														<td><c:out value="${loan.employee.name}"></c:out></td>  --%>
<%-- 														<td><c:out value="${loan.loand_date}"></c:out></td>  --%>
<%-- 														<td><c:out value="${loan.due_date}"></c:out></td>  --%>
<%-- 														<td><c:out value="${loan.returned_date}"></c:out></td>  --%>
<%-- 														<td><c:out value="${loan.fine}"></c:out></td>   --%>
<!-- 														<td> -->
<!-- 															<button type="button" class="btn btn-outline-primary waves-effect waves-light col-md-12 editBtn"  >Edit</button> &nbsp; -->
<!-- <!-- 															<button type="button" id ="deleteBtnId" class="btn btn-outline-danger waves-effect waves-light col-md-5 deleteBtn" >Delete</button> --> -->
<!-- 														</td> -->
<!-- 													</tr> -->
<%-- 												</c:when>  --%>
<%-- 											</c:choose>  --%>
<%-- 										</c:forEach>  --%>
<!--                                    </tbody> -->
<!--                                </table> -->
<!-- 							</div>  -->
<!-- <!--                            </div> --> -->
<!-- <!--                        </div> --> -->
<!--                     </div> -->
<!--                 </main> -->
<%--                  <%@include file="../common/footer.jsp"%>   --%>
<!--             </div> -->
<!--         </div>  -->
<%--         <%@include file="../common/scripts.jsp"%>  --%>
<!--         <script>  -->
        
//         var map = new Map();
//         $(".editBtn").click(function (){
//         	$(this).closest('tr').find('td').each(function(index) {
// 			      var textval = $(this).text();
// 			       map.set(index, textval);
// 			});
//         	$("#id").val(map.get(1));
//         	$('#book option[value=\''+map.get(2)+'\']').attr('selected','selected');
// 			$('#employee option[id=\''+map.get(4)+'\']').attr('selected','selected');
// 			$("#loand_date").val(map.get(5)); 
// 			$("#due_date").val(map.get(6)); 
// // 			$("#returned_date").val(map.get(7)); 
// // 			$("#fine").val(map.get(8)); 
// 			$("#addReturnModal").modal('show');   
//         });
        
        
//         $('.deleteBtn').click(function (e){ 
//     		$(this).closest('tr').find('td').each(function(index) {
//     		      var textval = $(this).text();
//     		       map.set(index, textval);
//     		});
//     		var id = map.get(1);
//     		Swal.fire({
//     			  title: 'Are you sure?',
// //     			  text: "You won't be able to revert this!",
//     			  icon: 'warning',
//     			  showCancelButton: true,
//     			  confirmButtonColor: '#d33',
//     			  cancelButtonColor: '#7a6fbe',
//     			  confirmButtonText: 'Delete !'
//     			}).then((result) => {
//     			  if (result.isConfirmed) { deleteReturn(id); }
//     			});
//     	}); 
		
<!--         </script> -->
<!--     </body> -->
<!-- </html>  -->