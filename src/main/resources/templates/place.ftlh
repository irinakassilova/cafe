<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <h1>${place.name}</h1>
    <img src="${place.image}" alt="Photo of place front" width="100">

    <h2>Our today menu!</h2>
    <div class="flex flex-wrap" id="itemList">
        <#list items as listItem>
            <div class="flex flex-column box flex-v-center">
                <img class="food-icon" src="/images/${listItem.image}" alt="${listItem.name}">
                <#--                <a href="/foods/${listItem.id}">${listItem.name}</a>-->
                <h3>${listItem.name}</h3>
                <p>Цена: ${listItem.price}</p>

                <form action="/basket/add/${principal.name}" method="post">
                    <input name="id" type="hidden" value="${listItem.id}">
                    <input name="count" type="number" required placeholder="Введите количество товара">
                    <#--                    <input type="hidden" value="${principal.name}">-->
                    <button type="submit">Buy</button>
                    <#if _csrf??>
                        <input type="hidden"
                               name="${(_csrf.parameterName)!'csrf-param-name'}"
                               value="${(_csrf.token)!'csrf-token'}" />
                    </#if>
                </form>

            </div>
        </#list>
    </div>

    <#include "partials/pagination.ftlh">

    <div>
        <a href="/">Back to home page</a>
    </div>

</@main.renderWith>