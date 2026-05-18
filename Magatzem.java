class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (Article article : articles) {
            // El Martell de Thor és immòbil: Ni caduca ni canvia de qualitat
            if (article.nom.equals("Martell de Thor (Llegendari)")) {
                continue; // Salta al següent article sense fer res
            }

            // Tots els altres articles disminueixen els seus dies per vendre en 1
            article.diesPerVendre--;

            // Gestionar el comportament segons el tipus d'article
            if (article.nom.equals("Formatge Gidurat")) {
                if (article.qualitat < 50) {
                    article.qualitat++;
                }
                // Si ha vençut la data, el formatge millora el doble de ràpid
                if (article.diesPerVendre < 0 && article.qualitat < 50) {
                    article.qualitat++;
                }
            } else if (article.nom.equals("Entrades per al Concert del Trobador")) {
                if (article.diesPerVendre < 0) {
                    article.qualitat = 0; // Després del concert, qualitat 0
                } else if (article.diesPerVendre <= 5) {
                    article.qualitat += 3;
                } else if (article.diesPerVendre <= 10) {
                    article.qualitat += 2;
                } else {
                    article.qualitat += 1;
                }
                // Assegurar que les entrades no superen la qualitat de 50 abans del concert
                if (article.diesPerVendre >= 0 && article.qualitat > 50) {
                    article.qualitat = 50;
                }
            } else {
                // Articles Normals
                if (article.qualitat > 0) {
                    article.qualitat--;
                }
                // Si la data venç, la qualitat baixa el doble de ràpid
                if (article.diesPerVendre < 0 && article.qualitat > 0) {
                    article.qualitat--;
                }
            }
        }
    }
}