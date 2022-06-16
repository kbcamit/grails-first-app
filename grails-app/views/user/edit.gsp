%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        Update
    </div>
    <div class="card-body">
        <g:form controller="user" action="update">
            <g:hiddenField name="id" value="${user.id}"/>
            <g:render template="form" model="[edit:'yes']"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="update" value="Update"/>
                <g:link controller="user" action="index" class="btn btn-primary">Cancel</g:link>
            </div>
        </g:form>
    </div>
</div>