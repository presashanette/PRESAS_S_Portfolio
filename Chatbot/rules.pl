% family_relations.pl


% DYNAMIC FACT DECLARATION
:- dynamic male/1, female/1, parent_of/2, sibling_of/2, grandmother_of/2, grandfather_of/2, child_of/2.
:- dynamic son_of/2, daughter_of/2, aunt_of/2, uncle_of/2, brother_of/2, sister_of/2, relative_of/2.

% Fact Declaration Examples
% father_of('jen', 'jersey').
% female('jen'), parent_of('jen', 'jersey').
% female('mary'), parent_of('mary','shan').
% male('justin').
% sibling_of('jersey', 'justin').
% female('lar'), mother_of('mary', 'shan'), mother_of('mary','lar')

% RELATIONSHIPS
%parents_of(X,Y,Z) :- mother_of(X,Y), father_of(X,Z). %idk
%parents_of(X,Y,Z) :- child_of(X,Z), child_of(Y,Z). %X- child Y-child Z-parent
parents_of(X, Y, Z) :- parent_of(X, Z), parent_of(Y, Z), Z\= Y, Z\= X, Y\= X.
father_of(X,Y):- male(X), parent_of(X,Y), child_of(Y,X), X \= Y.
mother_of(X,Y):- female(X), parent_of(X,Y), child_of(Y,X),  X \= Y.
grandfather_of(X,Y):- male(X), parent_of(X,Z), parent_of(Z,Y), X \= Y, X \= Z, Y \= Z.
grandmother_of(X,Y):- female(X), parent_of(X,Z), parent_of(Z,Y), X \= Y, X \= Z, Y \= Z.
daughter_of(X,Y) :- female(X), parent_of(Y,X), \+sister_of(X,Y), X \= Y.
sibling_of(X,Y):- parent_of(Z,X), parent_of(Z,Y), X \= Y.
sister_of(X,Y):- female(X), sibling_of(X,Y), X \= Y.
brother_of(X,Y):- male(X), sibling_of(X,Y), X \= Y.
child_of(X,Y):- parent_of(Y,X), X \= Y.  % Y is parent name  X child name
son_of(X,Y) :- male(X), parent_of(Y,X), X \= Y.
%parents_of

aunt_of(X,Y):- female(X), parent_of(Z,Y), sister_of(X,Z), X \= Y, X \= Z, Y \= Z.
uncle_of(X,Y):- male(X), parent_of(Z,Y), brother_of(X,Z), X \= Y, X \= Z, Y \= Z.
relative_of(X,Y):- parent_of(X,Y); sibling_of(X,Y); aunt_of(X,Y); uncle_of(X,Y); grandfather_of(X,Y); grandmother_of(X,Y); child_of(X,Y).
children_of(X, Y, Z, W) :- parent_of(X, Y), parent_of(X, Z), parent_of(X, W), Y \= Z, Y \= W, Z \= W.
%male(X) :- gender(X, male).
%female(X) :- gender(X,female).


%sibling_of(X,Y):- mother_of(M, Y), mother_of(M,X), X \= Y.
%sibling_of(X,Y):- father_of(F, Y), father_of(F,X), X \= Y.
% unsure kung needed pa
% sibling_of(X,Y):- parent_of(Z,X), parent_of(Z,Y), X \= Y.
% brother_of(X,Y):- male(X), sibling_of(X,Y), X \= Y.
% sister_of(X,Y):- female(X), mother_of(M, Y), mother_of(M,X), X \= Y.

% genders
% STATEMENT PROMPTS
% query_prolog(sibling_of(X,Y)).

% QUESTION PROMPTS


