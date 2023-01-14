# Réalisation d'un système multi-agents centralisé à usage commercial

# Introduction

Dans la première partie Nous allons implémenter un système expert, se basant sur les directives
présentes sur le textbook fournit : "Constructing Intelligent Agents Using Java". Tel que notre système
expert devra contenir en tout deux domaines distincts , dont l’un est obligatoirement sur
les véhicule (exemple donné dans le textbook) , pour le deuxième qui doit être adapté au domaine
commercial nous avons opter pour un système de vente des Portables. Ainsi les catégories disponibles
devront être accessible à partir d’une même interface bien élaboré, c’est à dire de sorte à se que les
régles et résultats soient bien visibles.

Pour la deuxième partie Nous avons implémenter un environnement commercial décentralisé à base d’agents intelligents, sous forme d’un système expert, tel que cet environnement doit être composé d’un agent acheteur et un agent central et de plusieurs agents annexes , ainsi chaque agent annexe sera
responsable de la vente d’une catégorie tout en se basant que le système expert du première partie.
C’est à dire que l’agent central sera l’intermédiaire entre les agents acheteurs et les agents vendeurs.

# Partie 1: Réalisation d’un système Expert
# Description
Cette section va mettre les points sur un système expert réaliser durent le semestre académique.
Ce système expert a ete intégrer dans une application JavaFX afin de
manipuler différentes bases de connaissances et le mettre en disposition a des simples utilisateurs
avec une simple interface. Notre système expert est du type deux donc les règles de déductions son
de la forme :

SI( x1 [=,<,>, !=] v1 ET x1 [=,<,>, !=] v1 ET ... ET xn [=,<,>, !=] vn) ALORS ( ci )

Nous allons travaillé avec javaFX , nous allons utilise le modele MVC (Modèle,Vue,Contrôleurs)
pour l’implémentation de note premier partie.

![image1](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/base.png)

# présentation de l’interface graphique
Le programme démarre par l’intefrace pricipale notre application dispose six interfaces, une interface principale pour la manipulation des différentes parties du SE, deux pour la saisie de données
pour la base des connaissances véhicule, et une autre pour la base des connaissances sur des protables,
appeler Protbales et trois interfaces pour l’admin pour gérer notre base de connaissances.

# Interface principale

![image2](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/rule2.png)

Description de l’interface :

1. Rule base Display : affiche les règles d’inférences dans la textArea display.
2. Rule base Display : affiche les variables avec leur valeur actuel dans la textArea display.
3. Default test set : remis la valeur des variables a leur valeurs par défaut qui peut etre preciser
dans un ficher JSON a n’importe moment dans le système.
4. perform forward chaining : exécute le chainage avant dans le SE.

# autre fonctionnalités : 
L’application dispose d’un autre ensemble de fonctionnalités qui seront
présenté dans la figure ci-dessous qui sert a gérer l’état du système afin ou bien a crée une nouvelle
instance ou changer la base des règles et meme remettre le système a son état initial et peut changer
les bases via l’interface admin.

![image3](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/rule3.png)

# interface d’entrée
chacune des bases de règles impose des bases de connaissances différentes donc pour chaque base
de règles on a une interface d’entrée différente qui sera présenté dans ce qui suite

![image4](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/rule4.png)

![image5](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/rule5.png)

# Interface Administration
Depuis cette interface on peut changer notre base (regles,clauses,condition) meme ajouter de
regles ou supprimer et aussi modfier

![image6](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/admin1.png)

![image7](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/admin2.png)

![image8](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/admin3.png)

# Partie2 : Système Multi-Agents (SMA)

# Modélisation

Le but étant la création d’un système multi-agent composé d’un agent central communiquant avec
les différents agents annexes (vendeurs et acheteur) de sorte a ce que l’agent central soit au courant
des produits que propose chaque agent. agent acheteur envoie la requête a l’agent centrale et puis l
agent centrale envoie la demande a l’agent vendeur qui est responsable de cette demande puis l’agent
vendeur répond a l’agent centrale et l’agent centrale transmit la réponse a l’agent acheteur et qui dans
notre cas l’utilisateur.

![image9](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/iner.png)
# Fonctionnement
1. Utilisateur
- introduit les critères de choix qu’il juge important dans sa recherche d’un véhicule ou d’un
12 protablle.
2. Interface
- envoi les données introduites par l’utilisateur vers l’agent acheteur.
- réceptionne et affiche a l’utilisateur les messages provenant de l’agent achteur.
3. Agent acheteur
- permet à l’utilisateur de commander selon ce qu’il veut acheter voiture ou protable.
4. Agent central
- reçoit les données provenant de l’agent acheteur.
- envois la requête a l’agent concerné.
- réceptionne le résultat de la requête.
-envois la requete a l’agent acheteur.
5. Agent vendeur1 : Vehicule
- introduit les valeurs reçues à travers l’agent central dans son système expert, et infère l’existence ou pas d’un véhicule correspondant à ces caractéristique.
- retourne le résultat de l’inférence à l’agent central.
6. Agent vendeur2 : Portable
- procéder à l’inférence de vêtements à partir des données reçues. - retourner le résultat à l’agent
central.

L’utilisateur doit remplir le champs comme la premier partie pour voir ce qu’il veut prendre, aussi
il doit choisir la base portable ou voiture.

![image10](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/rule11.png)


aprés une autre interface montre les resultats et les chmpas aussi si l utilisateur veut continuer de
chercher ce qu’il veut

![image11](https://github.com/islam1997/R-alisation-d-un-syst-me-multi-agents-centralis-usage-commercial-sous-Java-l-aide-de-l-outil-JA/blob/master/Capture/rule112.png)






