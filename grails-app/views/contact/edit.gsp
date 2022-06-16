%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        Update
    </div>

    <div class="card-body">
        <g:form controller="contact" action="update">
            <g:hiddenField name="id" value="${contact.id}"/>
        %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="save" value="Save"/>
                <g:link controller="contact" action="index" class="btn btn-primary">Cancel</g:link>
            </div>
        </g:form>
    </div>
</div>