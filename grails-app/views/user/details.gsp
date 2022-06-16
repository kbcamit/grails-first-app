%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        ${user.firstName}
    </div>

    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <td>Name</td>
            </tr>
            </thead>
            <tbody>
            <g:each in="${user.contacts}" var="info">
                <tr>
                    <td>${info?.name}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>