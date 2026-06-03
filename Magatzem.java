class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        // Recorrem tots els articles del magatzem un per un amb un bucle
        for (Article article : articles) {

            // Cas 1: El Martell de Thor és un objecte llegendari
            // Com que ni caduca ni canvia de qualitat, passem directament al següent
            // article
            if (article.nom.equals("Martell de Thor (Llegendari)")) {
                continue;
            }

            // Resta de casos: Com que ja hem descartat el Martell de Thor, sabem que a tots
            // els altres articles els baixa en 1 el dia per vendre
            article.diesPerVendre--;

            // Cas 2: El Formatge Gidurat (Millora amb el temps)
            if (article.nom.equals("Formatge Gidurat")) {
                // Si encara no ha arribat al límit màxim de 50, li sumem 1 de qualitat
                if (article.qualitat < 50) {
                    article.qualitat++;
                }
                // Si a sobre ja ha caducat (dies < 0), millora el doble de ràpid (li sumem un
                // altre punt)
                if (article.diesPerVendre < 0 && article.qualitat < 50) {
                    article.qualitat++;
                }
            }

            // Cas 3: Les entrades del concert (Logica segons els dies que queden)
            else if (article.nom.equals("Entrades per al Concert del Trobador")) {
                // Si el concert ja ha passat, les entrades no valen res (qualitat 0)
                if (article.diesPerVendre < 0) {
                    article.qualitat = 0;
                }
                // Si queden 5 dies o menys, pugem la qualitat en 3
                else if (article.diesPerVendre <= 5) {
                    article.qualitat += 3;
                }
                // Si queden entre 6 i 10 dies, pugem la qualitat en 2
                else if (article.diesPerVendre <= 10) {
                    article.qualitat += 2;
                }
                // Si falta molt de temps (més de 10 dies), puja normal (en 1)
                else {
                    article.qualitat += 1;
                }

                // Control de seguretat: Si en sumar la qualitat ens hem passat de 50, la tornem
                // a frenar a 50 (ja que encara no ha passat el concert)
                if (article.diesPerVendre >= 0 && article.qualitat > 50) {
                    article.qualitat = 50;
                }
            }

            // Cas 4: Articles Normals (Tots els altres productes que no encaixen dalt)
            else {
                // Si té qualitat, li restem 1 punt com cada dia
                if (article.qualitat > 0) {
                    article.qualitat--;
                }
                // Si a sobre l'article ha caducat (dies < 0), baixa el doble de ràpid (li
                // restem un altre punt)
                if (article.diesPerVendre < 0 && article.qualitat > 0) {
                    article.qualitat--;
                }
            }

        }
    }
}