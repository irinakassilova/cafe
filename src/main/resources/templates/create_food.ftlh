<!doctype html>
<html lang="en">
<body>
<form action="" method="post">
    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name">
    </div>

    <div class="form-group">
        <label>Цена</label>
        <input type="number" min="1" name="price">
    </div>

    <div>
        <label>Description</label>
        <input type="text" name="description">
    </div>
    <div>
        <label>Image</label>
        <input type="text" name="image">
    </div>
    <div>
        <label class="form-label">Place</label>
        <select name="placeId">
            <#list places as place>
                <option value="${place.id}">${place.name}</option>
            </#list>
        </select>
    </div>

    <div>
        <#if errors?? >
            <p>Входные данные с ошибками!</p>
            <#list errors as fieldError>
                <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
            </#list>
        </#if>
    </div>
    <button class="btn btn-primary mt-2" type="submit">Добавить</button>
</form>
</body>
</html>
