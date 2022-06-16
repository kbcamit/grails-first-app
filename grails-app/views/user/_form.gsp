<div class="form-group">
    <label>First Name *</label>
    <g:textField name="firstName" class="form-control" value="${user?.firstName}" placeholder="Please Enter First Name"/>
</div>

<div class="form-group">
    <label>Last Name</label>
    <g:textField name="lastName" class="form-control" value="${user?.lastName}" placeholder="Please Last Name"/>
</div>

<div class="form-group">
    <label>Email *</label>
    <g:field type="email" name="email" class="form-control" value="${user?.email}" placeholder="Please Enter Email"/>
</div>

<g:if test="${!edit}">
    <div class="form-group">
        <label>Password *</label>
        <g:passwordField name="password" class="form-control" value="${user?.password}" placeholder="Please Enter Password"/>
    </div>
</g:if>