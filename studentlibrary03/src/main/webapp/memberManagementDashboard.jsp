<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<c:set var="serverContext" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Member Management Dashboard</title> 
        <%@include file="../common/header.jsp"%> 
    </head>
    <body class="sb-nav-fixed">
    	<%@include file="../common/navbar.jsp"%>  
        <div id="layoutSidenav">
        	<%@include file="../common/sidebar.jsp"%> 
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h3 class="mt-4">Member Management</h3>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item ">Members</li>
                            <li class="breadcrumb-item active">Member Management</li>
                        </ol>
					<div class="row">
						<div class="col-12">
							<div class="card text-center">
								<div class="card-body ">
									<div class="py-4" data-bs-toggle="modal" data-bs-target="#addMemberModal">
										<h4 class="font-500">Add New Member</h4>
										<button class="btn btn-block btn-lg" > <i class="fas fa-plus"></i> </button>
									</div>
								</div>
							</div>
						</div> 
					</div> 
<!--                   ============================================================== -->
<!--                   					   Modal START  								-->
<!--                   ============================================================== -->                         
               
               <div class="modal fade" id="addMemberModal">
				  <div class="modal-dialog">
				    <div class="modal-content">  
				      <div class="modal-header">
				        <h2 class="modal-title">Add Member</h2>
				        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				      </div>  
				      <div class="modal-body">
				        <form:form class="row g-3" action="saveMemberObject" modelAttribute="member" method="POST">
						  <div class="col-md-6">
						    <label for="empcode" class="form-label">Employee Code</label>
						    <form:input type="number" class="form-control" id="empcode" path="empcode" required="required"/> 
						  </div>
						   <div class="col-md-6">
						    <label for="name" class="form-label">Name</label>
						    <form:input type="text" class="form-control" id="name" path="name" required="required"/> 
						  </div>
						  <div class="col-md-6">
						    <label for="age" class="form-label">Age</label> 
						    <form:input type="number" class="form-control" id="age" path="age" required="required"/>
						  </div> 
						  <div class="col-md-6">
						    <label for="gender" class="form-label">Gender</label> 
						    <div class="form-check">
						    	<label for="male">Male</label>
							   	<form:radiobutton id="male" value="male" path="gender" checked="checked"/>&nbsp;&nbsp;
						        <label for="female">Female</label>
						        <form:radiobutton id="female" path="gender" value="female" />
<%-- 								<form:input type="checkbox" class="form-control" id="gender" path="gender" required="required"/> --%>
						  	</div>
						  </div>
						  <div class="col-md-6">
						    <label for="department" class="form-label">Department</label> 
								<form:input type="text" class="form-control" id="department" path="department" required="required"/>
						  </div> 
						  <div class="col-md-6">
						    <label for="designation" class="form-label">Designation</label>
						    <form:input type="text" class="form-control" id="designation" path="designation" required="required"/>
						  </div> 
						  <div class="col-md-12">
						    <label for="email" class="form-label">Email</label>
						    <form:input type="email" class="form-control" id="email" path="email" required="required"/>
						  </div> 
						  <div class="col-md-12">
						    <label for="mobile" class="form-label">Mobile No</label> 
								<form:input type="number" class="form-control" id="mobile" path="mobile" required="required"/>
						  </div>
						  <div class="col-md-12 text-center">
						      <button class="btn btn-primary w-100" type="submit">Submit form</button>
						  </div> 
						</form:form>
				      </div>   
				    </div>
				  </div>
				</div> 
                
                
<!--                   ============================================================== -->
<!--                   					   Modal START  								-->
<!--                   ============================================================== -->           


                       <div class="card mt-4">
                           <div class="card-header"> <i class="fas fa-table me-1"></i> All Members </div> 
                           <div class="card-body"> 
							<div class="mt-4">
								<table id="datatable-buttons" class="table table-striped table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                                	<thead>
                                    	<tr>
	                                     	<th>#</th> 
	                                        <th>Reg No</th>
	                                        <th>Member Name</th> 
											<th>Age</th>
											<th>Department</th>
											<th>Designation</th>
											<th>Gender</th>
											<th>Email</th>
											<th>Mobile No</th>
											<th>Edit</th>
                                        </tr>
                                     </thead>  
                                     <tbody>
                                        <c:set var="count" value="0" scope="page" />
										<c:forEach varStatus="loopCounter" items="${memberList}" var="member">
											<c:choose>
												<c:when test="${not empty member }">
													<tr>
														<c:set var="count" value="${count + 1}" scope="page" />
														<td><c:out value="${count}"></c:out></td> 
														<td><c:out value="${member.empcode}"></c:out></td>
														<td><c:out value="${member.name}"></c:out></td> 
														<td><c:out value="${member.age}"></c:out></td> 
														<td><c:out value="${member.department}"></c:out></td> 
														<td><c:out value="${member.designation}"></c:out></td> 
														<td><c:out value="${member.gender}"></c:out></td> 
														<td><c:out value="${member.email}"></c:out></td> 
														<td><c:out value="${member.mobile}"></c:out></td> 
														<td>
															<button type="button" class="btn btn-outline-primary waves-effect waves-light col-md-5 editBtn"  >Edit</button> &nbsp;
															<button type="button" id ="deleteBtnId" class="btn btn-outline-danger waves-effect waves-light col-md-5 deleteBtn" >Delete</button>
														</td>
													</tr>
												</c:when> 
											</c:choose> 
										</c:forEach> 
                                   </tbody>
                               </table>
							</div> 
                           </div>
                       </div>
                    </div>
                </main>
                 <%@include file="../common/footer.jsp"%>  
            </div>
        </div> 
        <%@include file="../common/scripts.jsp"%> 
        <script> 
        
        var map = new Map();
        $(".editBtn").click(function (){
        	$(this).closest('tr').find('td').each(function(index) {
			      var textval = $(this).text();
			       map.set(index, textval);
			}); 
			$("#empcode").val(map.get(1)); 
			$("#name").val(map.get(2)); 
			$("#age").val(map.get(3)); 
			$("#department").val(map.get(4)); 
			$("#designation").val(map.get(5)); 
			$('#'+map.get(6)+'').attr('checked','checked');
// 			$('#gender option[value=\''+map.get(6)+'\']').attr('checked','checked');
			$("#email").val(map.get(7)); 
			$("#mobile").val(map.get(8)); 
			$("#addMemberModal").modal('show');   
        });
         
        $('.deleteBtn').click(function (e){ 
    		$(this).closest('tr').find('td').each(function(index) {
    		      var textval = $(this).text();
    		       map.set(index, textval);
    		});
    		var id = map.get(1);
    		Swal.fire({
    			  title: 'Are you sure?',
//     			  text: "You won't be able to revert this!",
    			  icon: 'warning',
    			  showCancelButton: true,
    			  confirmButtonColor: '#d33',
    			  cancelButtonColor: '#7a6fbe',
    			  confirmButtonText: 'Delete !'
    			}).then((result) => {
    			  if (result.isConfirmed) { deleteMember(id); }
    			});
    	});
        
        function deleteMember(id){
			$.ajax({
				type : "DELETE",
				url : "members/"+ id,
				success : function(response) {
					if (response) {
		            	Swal.fire({
		            		icon: 'success',
		                    title: "Member Deleted Successfully",
		                    type: "success"
		                }).then(function (){
			                	window.location = "memberManagementDashboard" ;
			            });
		            } else {
		            	Swal.fire({
	            			icon: 'error',
	                    	title: "",
	                    	text: "Please Try Again"
	                	});
					}},
				error : function(e) {
					console.log("ERROR: ", e);
					alert("Please Contact the System Admin");
				}
			});
		}
		
        </script>
    </body>
</html> 