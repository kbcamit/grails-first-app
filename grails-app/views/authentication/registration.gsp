<meta name="layout" content="auth"/>

<div class="card">
    <div class="card-header">
        User Registration
    </div>
    <div class="card-body">
        <g:form controller="authentication" action="doRegistration">
            <g:render template="/user/form"/>
            <g:submitButton name="registration" value="Registration" class="btn btn-primary"/>
            <g:link controller="authentication" action="login" class="btn btn-primary">Back to login</g:link>
        </g:form>
    </div>
</div>