%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        List

        %{--Actions--}%
        <span class="float-right">
            %{--Create and Reload Panel--}%
            <div class="btn-group">
                <g:link controller="contact" action="create" class="btn btn-success">Create</g:link>
                <g:link controller="contact" action="index" class="btn btn-primary">Reload</g:link>
            </div>
        </span>
    </div>

    %{--Table Panel--}%
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <td>Contact Name</td>
                <th class="action-row">Action</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${contacts}" var="info">
                <tr>
                    <td>${info?.name}</td>

                    %{--Table Actions --}%
                    <td>
                        <div class="btn-group">
                            <g:link controller="contact" action="edit" class="btn btn-secondary" id="${info.id}">Edit</g:link>
%{--                            <g:link controller="user" action="delete" id="${info.id}"--}%
%{--                                    class="btn btn-secondary delete-confirmation">Delete</g:link>--}%
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>