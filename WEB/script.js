// Função para mostrar/ocultar a lista ao clicar no botão
function toggleList() {
    document.getElementById("dropdownList").classList.toggle("show");
}

// Função para filtrar os itens da lista
function filterList() {
    var input, filter, ul, li, i, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("listItems");
    li = ul.getElementsByTagName("li");

    for (i = 0; i < li.length; i++) {
        txtValue = li[i].textContent || li[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

// Fechar o dropdown se o usuário clicar fora
window.onclick = function(event) {
    if (!event.target.matches('.dropbtn') && !event.target.matches('.input-drop')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

