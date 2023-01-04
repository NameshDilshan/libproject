<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<c:set var="serverContext" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Book Management Dashboard</title> 
        <%@include file="../common/header.jsp"%> 
    </head>
    <body class="sb-nav-fixed">
    	<%@include file="../common/navbar.jsp"%>  
        <div id="layoutSidenav">
        	<%@include file="../common/sidebar.jsp"%> 
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h3 class="mt-4">Book Management</h3>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item ">Books</li>
                            <li class="breadcrumb-item active">Book Management</li>
                        </ol>
					<div class="row">
						<div class="col-12">
							<div class="card text-center">
								<div class="card-body ">
									<div class="py-4" data-bs-toggle="modal" data-bs-target="#addBookModal">
										<h4 class="font-500">Add New Book</h4>
										<button class="btn btn-block btn-lg" > <i class="fas fa-plus"></i> </button>
									</div>
								</div>
							</div>
						</div> 
					</div> 
<!--                   ============================================================== -->
<!--                   					   Modal START  								-->
<!--                   ============================================================== -->                         
               
               <div class="modal fade" id="addBookModal">
				  <div class="modal-dialog">
				    <div class="modal-content">  
				      <div class="modal-header">
				        <h2 class="modal-title">Add Book</h2>
				        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				      </div>  
				      <div class="modal-body">
				        <form:form class="row g-3" action="saveBook" modelAttribute="book" method="POST">
						  <div class="col-md-6">
						    <label for="id" class="form-label">Id</label>
						    <form:input type="number" class="form-control" id="id" path="id" required="required"/> 
						  </div>
						   <div class="col-md-6">
						    <label for="year" class="form-label">Year</label>
						    <form:input type="year" class="form-control" id="year" path="year" required="required"/> 
						  </div>
						  <div class="col-md-12">
						    <label for="name" class="form-label">Title</label> 
						    <form:input type="text" class="form-control" id="title" path="title" required="required"/>
						  </div>  
						  <div class="col-md-6">
						    <label for="edition" class="form-label">Edition</label>
							<form:select id="edition" path="edition" class="form-control"> 
								<option selected="selected" disabled="disabled" value="">Choose...</option>
								<option value="1st Edition" id="1stEdition">1st Edition</option>
								<option value="2nd Edition" id="2ndtEdition">2nd Edition</option>
								<option value="3rd Edition" id="3rdEdition">3rd Edition</option>
								<option value="Limited Edition" id="limitedEdition">Limited Edition</option>
								<option value="Signed Edition" id="signedEdition">Signed Edition</option>
								<option value="Collectable Edition" id="collectableEdition">Collectable Edition</option>
								<option value="Revised & Updated Edition" id="redisedAndUpdatedEdition">Revised &nbsp; Updated Edition</option>
							</form:select>
						</div>
						<div class="col-md-6">
						    <label for="category" class="form-label">Category</label>
							<form:select id="category" path="category" class="form-control"> 
								<option selected="selected" disabled="disabled" value="">Choose...</option>
								<option value="Adventure" id="adventure">Adventure</option>
								<option value="Classics" id="classics">Classics</option>
								<option value="Crime" id="crime">Crime</option>
								<option value="Fairy tales" id="fairy">Fairy tales</option>
								<option value="Fantasy" id="Fantasy">Fantasy</option>
								<option value="Other" id="Other">Other</option>
							</form:select>
						</div>
						<div class="col-md-6">
						    <label for="price" class="form-label">Price</label> 
								<form:input type="text" class="form-control" id="price" path="price" />
						  </div>
						  <div class="col-md-12">
						    <label for="description" class="form-label">Description</label>
						    <form:input type="text" class="form-control" id="description" path="description" />
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

 
							<div class="mt-4">
								<table id="datatable-buttons" class="table table-striped table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                                	<thead>
                                    	<tr>
	                                     	<th>#</th> 
	                                        <th>Id</th>
	                                        <th>Book Title</th> 
											<th>Book Year</th>
											<th>Book Category</th>
											<th>Book Edition</th>
											<th>Book Description</th>
											<th>Book Price</th>
											<th>Edit</th>
                                        </tr>
                                     </thead>  
                                     <tbody>
                                        <c:set var="count" value="0" scope="page" />
										<c:forEach varStatus="loopCounter" items="${bookList}" var="book">
											<c:choose>
												<c:when test="${not empty book }">
													<tr>
														<c:set var="count" value="${count + 1}" scope="page" />
														<td><c:out value="${count}"></c:out></td> 
														<td><c:out value="${book.id}"></c:out></td>
														<td><c:out value="${book.title}"></c:out></td> 
														<td><c:out value="${book.year}"></c:out></td> 
														<td><c:out value="${book.category}"></c:out></td> 
														<td><c:out value="${book.edition}"></c:out></td> 
														<td><c:out value="${book.description}"></c:out></td> 
														<td><c:out value="${book.price}"></c:out></td> 
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
			$("#id").val(map.get(1)); 
			$("#title").val(map.get(2)); 
			$("#year").val(map.get(3)); 
// 			$("#category").val(map.get(4)); 
			$("#description").val(map.get(6)); 
			$("#price").val(map.get(7));
			$('#edition option[value=\''+map.get(5)+'\']').attr('selected','selected');
			$('#category option[value=\''+map.get(4)+'\']').attr('selected','selected');
// 			$('#locationTypeId option[value=\''+map.get(4)+'\']').attr('selected','selected');
			$("#addBookModal").modal('show'); 
			$("#id").prop("readonly", "readonly"); 
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
    			  if (result.isConfirmed) { deleteBook(id); }
    			});
    	});
        
        function deleteBook(id){
			$.ajax({
				type : "DELETE",
				url : "books/"+ id,
				success : function(response) {
					if (response) {
		            	Swal.fire({
		            		icon: 'success',
		                    title: "Book Deleted Successfully",
		                    type: "success"
		                }).then(function (){
			                	window.location = "bookManagementDashboard" ;
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