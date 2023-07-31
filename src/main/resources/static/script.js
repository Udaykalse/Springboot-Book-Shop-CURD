function showSortOptions() {
            var sortOptions = document.getElementById("sortOptions");
            sortOptions.style.display = "block";
        }

        function hideSortOptions() {
            var sortOptions = document.getElementById("sortOptions");
            sortOptions.style.display = "none";
        }

        function sortByBookName() {
            var cards = Array.from(document.getElementsByClassName("card"));

            cards.sort(function(a, b) {
                var nameA = a.querySelector(".card-title").innerText.toLowerCase();
                var nameB = b.querySelector(".card-title").innerText.toLowerCase();
                return nameA.localeCompare(nameB);
            });

            var cardContainer = document.getElementById("cardContainer");
            cardContainer.innerHTML = "";

            cards.forEach(function(card) {
                cardContainer.appendChild(card);
            });
        }

        function sortByPrice() {
            var cards = Array.from(document.getElementsByClassName("card"));

            cards.sort(function(a, b) {
                var priceA = parseFloat(a.querySelector(".card-price").innerText);
                var priceB = parseFloat(b.querySelector(".card-price").innerText);
                return priceA - priceB;
            });

            var cardContainer = document.getElementById("cardContainer");
            cardContainer.innerHTML = "";

            cards.forEach(function(card) {
                cardContainer.appendChild(card);
            });
        }

        function searchBooks() {
            var input, filter, cardContainer, cards, cardTitle, i, txtValue;
            input = document.getElementById("searchInput");
            filter = input.value.toUpperCase();
            cardContainer = document.getElementById("cardContainer");
            cards = cardContainer.getElementsByClassName("col");

            for (i = 0; i < cards.length; i++) {
                cardTitle = cards[i].querySelector(".card-title");
                txtValue = cardTitle.textContent || cardTitle.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    cards[i].style.display = "";
                } else {
                    cards[i].style.display = "none";
                }
            }
        }