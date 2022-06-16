%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        Create
    </div>
    <div class="card-body">
        <g:form controller="user" action="save">

        %{--Partial Templating--}%
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="save" value="Save"/>
                <g:link controller="user" action="index" class="btn btn-primary">Cancel</g:link>
            </div>
        </g:form>
    </div>
</div>