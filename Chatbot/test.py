from pyswip import Prolog

import re

prolog = Prolog()
prolog.consult("rules.pl")


def query_prolog(relation, person):
    try:
        result = list(prolog.query(f"{relation}_of(X, '{person}')"))
        return [r["X"] for r in result]
    except Exception as e:
        print("An error occurred:", e)
        return None

def print_relationshipONE(relationship_type, person_name, prolog_query):
    print(f'{relationship_type} of {person_name}:')
    answer = list(prolog.query(prolog_query))
    if answer:
        for result in answer:
            x_value = result['X']
            print(f' {x_value}')
    else:
        print("None!")
def are_relationship_ISYESORNO(relationship, prolog_query):
    #(f'{relationship}:')
    answer = bool(list(prolog.query(prolog_query)))
    if answer:
        answer = "Bot: Yes!"
    else:
        answer = "Bot: No!"
    print(answer)


def check_knowledge_base(query):
    questions = [r"are (\w+) and (\w+) siblings?",
                 r"is (\w+) a sister of (\w+)?",
                 r"is (\w+) a brother of (\w+)?",
                 r"is (\w+) the mother of (\w+)?",
                 r"is (\w+) the father of (\w+)?",
                 r"are (\w+) and (\w+) the parents of (\w+)?",
                 r"is (\w+) a grandmother of (\w+)?",
                 r"is (\w+) a daughter of (\w+)?",
                 r"is (\w+) a son of (\w+)?",
                 r"is (\w+) a child of (\w+)?",
                 #r"are (\w+), (\w+) and (\w+) children of (\w+)?",
                 r"who are the children of (\w+)?",
                 r"is (\w+) an uncle of (\w+)?",
                 r"who are the siblings of (\w+)?",
                 r"who are the sisters of (\w+)?",
                 r"who are the brothers of (\w+)?",
                 r"who is the mother of (\w+)?",
                 r"who is the father of (\w+)?",
                 r"who are the parents of (\w+)?",
                 r"is (\w+) a grandfather of (\w+)?",
                 r"who are the daughters of (\w+)?",
                 r"who are the sons of (\w+)?",
                 r"are (.+?) children of (.+?)\?",
                 r"is (\w+) an aunt of (\w+)?",
                 r"are (\w+) and (\w+) relatives?",
                 r"is (\w+) female?",
                 r"is (\w+) male?"]
    i = 0
    for x in questions:
        match = re.search(x, query)

        if match:
            if i == 0:
                are_relationship_ISYESORNO('Sibling', f'sibling_of({match.group(1)}, {match.group(2)})')
            elif i == 1:
                are_relationship_ISYESORNO('Sister', f'sister_of({match.group(1)}, {match.group(2)})')
            elif i == 2:
                are_relationship_ISYESORNO('Brother', f'brother_of({match.group(1)}, {match.group(2)})')
            elif i == 3:
                are_relationship_ISYESORNO('Mother', f'mother_of({match.group(1)}, {match.group(2)})')
            elif i == 4:
                are_relationship_ISYESORNO('Father', f'father_of({match.group(1)}, {match.group(2)})')
            elif i == 5:
                #print("Parents")
                answer = bool(list(prolog.query(
                    f'parents_of({match.group(1)}, {match.group(2)}, {match.group(3)})')))
                if answer:
                    answer = "Yes!"
                else:
                    answer = "No!"
                print(answer)
            elif i == 6:
                are_relationship_ISYESORNO('GrandMother', f'grandmother_of({match.group(1)}, {match.group(2)})')
            elif i == 7:
                are_relationship_ISYESORNO('Daughter', f'daughter_of({match.group(1)}, {match.group(2)})')
            elif i == 8:
                are_relationship_ISYESORNO('Son', f'son_of({match.group(1)}, {match.group(2)})')
            elif i == 9:
                are_relationship_ISYESORNO('Child', f'child_of({match.group(1)}, {match.group(2)})')
            elif i == 21:
                children_string = match.group(1)
                parent = match.group(2)

                children = [child.strip() for child in re.split(r',\s*|\s+and\s*|\s+', children_string) if
                            child.lower() != 'and']

                queries = [f'child_of({child}, {parent})' for child in children]

                query_results = [bool(list(prolog.query(query))) for query in queries]

                all_queries_true = all(query_results)
                if all_queries_true:
                    answer = "Yes!"
                else:
                    answer = "No!"
                print(answer)
            elif i == 11:
                are_relationship_ISYESORNO('Uncle', f'uncle_of({match.group(1)}, {match.group(2)})')
            elif i == 12:
                print_relationshipONE('Siblings ', match.group(1), f'sibling_of(X,{match.group(1)})')
            elif i == 13:
                print_relationshipONE('Sisters ', match.group(1), f'sister_of(X,{match.group(1)})')
            elif i == 14:
                print_relationshipONE('Brothers ', match.group(1), f'brother_of(X,{match.group(1)})')
            elif i == 15:
                answer = list(prolog.query(f'mother_of(X, {match.group(1)})'))
                if answer:
                    x_value = answer[0]['X']
                    print(f'Mother of {match.group(1)}: {x_value}')
                else:
                    print("None!")
            elif i == 16:
                answer = list(prolog.query(f'father_of(X, {match.group(1)})'))
                if answer:
                    x_value = answer[0]['X']
                    print(f'Father of {match.group(1)}: {x_value}')
                else:
                    print("None!")
            elif i == 17:
                print_relationshipONE('Parents', match.group(1), f'parent_of(X,{match.group(1)})')
            elif i == 18:
                are_relationship_ISYESORNO('Grandfather', f'grandfather_of({match.group(1)}, {match.group(2)})')
            elif i == 19:
                print_relationshipONE('Daughters', match.group(1), f'daughter_of(X,{match.group(1)})')
            elif i == 20:
                print_relationshipONE('Sons', match.group(1), f'son_of(X,{match.group(1)})')
            elif i == 10:
                #print_relationshipONE('Children of ', match.group(1), f'child_of(X,{match.group(1))})')
                query_result = list(prolog.query(f'child_of(X, \'{match.group(1)}\')'))
                if query_result:
                    for result in query_result:
                        x_value = result['X']
                        print(f'Child: {x_value}')
                else:
                    print("No children found.")
            elif i == 22:
                are_relationship_ISYESORNO('Aunt', f'aunt_of({match.group(1)}, {match.group(2)})')
            elif i == 23:
                are_relationship_ISYESORNO('Relatives', f'relative_of({match.group(1)}, {match.group(2)})')
            elif i == 24:
                are_relationship_ISYESORNO('Female', f'female({match.group(1)})')
            elif i == 25:
                are_relationship_ISYESORNO('Male', f'male({match.group(1)})')
            break
        i += 1
    else:
        print("Bot: I don't understand. Please use one of the recognized formats.")

def process_input(user_input):
    statements = [r"(\w+) and (\w+) are siblings.",
                  r"(\w+) is a sister of (\w+).",
                  r"(\w+) is the mother of (\w+).",
                  r"(\w+) is a grandmother of (\w+).",
                  r"(\w+) is a child of (\w+).",
                  r"(\w+) is a daughter of (\w+).",
                  r"(\w+) is an uncle of (\w+).",
                  r"(\w+) is a brother of (\w+).",
                  r"(\w+) is the father of (\w+).",
                  r"(\w+) and (\w+) are the parents of (\w+).",
                  r"(\w+) is a grandfather of (\w+).",
                  #r"(\w+), (\w+) and (\w+) are children of (\w+).",
                  r"(.+?) are children of (.+?)\.",
                  r"(\w+) is a son of (\w+).",
                  r"(\w+) is an aunt of (\w+)."]

    i = 0
    for x in statements:
        match = re.search(x, user_input)

        if match:
            sibling = f'sibling_of({match.group(1)}, {match.group(2)})'
            sister = f'sister_of({match.group(1)}, {match.group(2)})'
            brother = f'brother_of({match.group(1)}, {match.group(2)})'
            mother = f'mother_of({match.group(1)}, {match.group(2)})'
            father = f'father_of({match.group(1)}, {match.group(2)})'
            parents = f'parent_of({match.group(1)}, {match.group(2)})'
            grandmother = f'grandmother_of({match.group(1)}, {match.group(2)})'
            daughter = f'daughter_of({match.group(1)}, {match.group(2)})'
            son = f'son_of({match.group(1)}, {match.group(2)})'
            child = f'child_of({match.group(1)}, {match.group(2)})'
            uncle = f'uncle_of({match.group(1)}, {match.group(2)})'
            grandfather = f'grandfather_of({match.group(1)}, {match.group(2)})'
            aunt = f'aunt_of({match.group(1)}, {match.group(2)})'

            if i == 0:
                #print("siblings")

                if {match.group(1)} != {match.group(2)}:
                    prolog.assertz(f'sibling_of({match.group(1)}, {match.group(2)})')
                    print("Bot: OK! I learned something.")
                else:
                    print("Bot: That's impossible!")
            elif i == 1:
                #print("sister")

                is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                            bool(list(prolog.query(f'male({match.group(1)})'))))

                val1 = bool(list(prolog.query(daughter)))
                val2 = bool(list(prolog.query(mother)))
                val3 = bool(list(prolog.query(child)))
                val4 = bool(list(prolog.query(grandmother)))
                val5 = bool(list(prolog.query(aunt)))

                if not val1 and not val2 and not val3 and not val4 and not val5 \
                        and {match.group(1)} != {match.group(2)}:
                    if not is_valid:
                        prolog.assertz(f'female({match.group(1)})')
                        prolog.assertz(f'sibling_of({match.group(1)}, {match.group(2)})')
                        prolog.assertz(f'sibling_of({match.group(2)}, {match.group(1)})')
                        sibs = list(prolog.query(f'sibling_of(X,{match.group(1)})'))
                        if len(sibs) > 0:
                            for s in sibs:
                                X_val = s['X']
                                prolog.assertz(f'sister_of({match.group(1)},{X_val})')
                        print("Bot: OK! I learned something.")
                    elif bool(list(prolog.query(f'female({match.group(1)})'))):
                        # prolog.assertz(f'sister_of({match.group(1)}, {match.group(2)})')
                        prolog.assertz(f'sibling_of({match.group(1)}, {match.group(2)})')
                        prolog.assertz(f'sibling_of({match.group(2)}, {match.group(1)})')
                        sibs = list(prolog.query(f'sibling_of(X,{match.group(1)})'))
                        if len(sibs) > 0:
                            for s in sibs:
                                X_val = s['X']
                                prolog.assertz(f'sister_of({match.group(1)},{X_val})')
                        print("Bot: OK! I learned something.")
                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")
            elif i == 2:
                #print("mother")

                parent = list(prolog.query(f'mother_of(X,{match.group(2)})'))
                if len(parent) == 0:

                    is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                                bool(list(prolog.query(f'male({match.group(1)})'))))

                    val1 = bool(list(prolog.query(sister)))
                    val2 = bool(list(prolog.query(grandmother)))
                    val6 = bool(list(prolog.query(f'grandmother_of({match.group(2)}, {match.group(1)})')))
                    val3 = bool(list(prolog.query(child)))
                    val4 = bool(list(prolog.query(daughter)))
                    val5 = bool(list(prolog.query(aunt)))

                    if not val1 and not val2 and not val3 and not val4 and not val5 and not val6 \
                            and {match.group(1)} != {match.group(2)}:
                        if not is_valid:
                            prolog.assertz(f'female({match.group(1)})')
                            prolog.assertz(f'parent_of({match.group(1)}, {match.group(2)})')
                            prolog.assertz(f'child_of({match.group(2)}, {match.group(1)})')

                            print("Bot: OK! I learned something.")
                        elif bool(list(prolog.query(f'female({match.group(1)})'))):
                            prolog.assertz(f'parent_of({match.group(1)}, {match.group(2)})')
                            prolog.assertz(f'child_of({match.group(2)}, {match.group(1)})')
                            print("Bot: OK! I learned something.")
                        else:
                            print("Bot: That's impossible!")
                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")

            elif i == 3:
                #print("grandmother")

                grandmothers = list(prolog.query(f'grandmother_of(X, {match.group(2)})'))
                if len(grandmothers) < 2:
                    val1 = bool(list(prolog.query(daughter)))
                    val2 = bool(list(prolog.query(mother)))
                    val3 = bool(list(prolog.query(child)))
                    val4 = bool(list(prolog.query(aunt)))
                    val7 = bool(list(prolog.query(f'aunt_of({match.group(2)}, {match.group(1)})')))
                    val5 = bool(list(prolog.query(sister)))
                    val6 = bool(list(prolog.query(parents)))

                    is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                                bool(list(prolog.query(f'male({match.group(1)})'))))

                    if not val1 and not val2 and not val3 and not val4 and not val5 \
                            and not val6 and not val7 and {match.group(1)} != {match.group(2)}:
                        kids = list(prolog.query(f'child_of(X, {match.group(1)})'))
                        parent = list(prolog.query(f'parent_of(X, {match.group(2)})'))
                        if not is_valid:
                            if len(parent) < 2:
                                prolog.assertz(f'female({match.group(1)})')
                                prolog.assertz(f'grandmother_of({match.group(1)}, {match.group(2)})')
                                print("Bot: OK! I learned something.")
                            else:  # if len(parent) == 2
                                for p in parent:
                                    for k in kids:
                                        if k == p:
                                            prolog.assertz(f'female({match.group(1)})')
                                            prolog.assertz(f'grandmother_of({match.group(1)}, {match.group(2)})')
                                            print("Bot: OK! I learned something.")
                                        else:
                                            print("Bot: That's impossible!")
                        elif bool(list(prolog.query(f'female({match.group(1)})'))):
                            if len(parent) < 2:
                                # prolog.assertz(f'male({match.group(1)})')
                                prolog.assertz(f'grandmother_of({match.group(1)}, {match.group(2)})')
                                print("Bot: OK! I learned something.")
                            else:  # if len(parent) == 2
                                for p in parent:
                                    for k in kids:
                                        if k == p:
                                            # prolog.assertz(f'male({match.group(1)})')
                                            prolog.assertz(f'grandmother_of({match.group(1)}, {match.group(2)})')
                                            print("Bot: OK! I learned something.")
                                        else:
                                            print("Bot: That's impossible!")

                        else:
                            print("Bot: That's impossible!")
                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")



            elif i == 4:
                #print("child")

                val1 = bool(list(prolog.query(sibling)))
                val2 = bool(list(prolog.query(parents)))
                val3 = bool(list(prolog.query(grandfather)))
                val4 = bool(list(prolog.query(grandmother)))
                val5 = bool(list(prolog.query(aunt)))
                val6 = bool(list(prolog.query(uncle)))

                if not val1 and not val2 and not val3 and not val4 and not val5 \
                        and not val6 and {match.group(1)} != {match.group(2)}:
                    prolog.assertz(f'child_of({match.group(1)}, {match.group(2)})')
                    prolog.assertz(f'parent_of({match.group(2)}, {match.group(1)})')
                    print("Bot: OK! I learned something.")
                else:
                    print("Bot: That's impossible!")

            elif i == 5:
                #print("daughter")

                is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                            bool(list(prolog.query(f'male({match.group(1)})'))))

                val1 = bool(list(prolog.query(sister)))
                val2 = bool(list(prolog.query(mother)))
                val3 = bool(list(prolog.query(child)))
                val4 = bool(list(prolog.query(grandmother)))
                val5 = bool(list(prolog.query(aunt)))

                if not val1 and not val2 and not val3 and not val4 and not val5\
                        and {match.group(1)} != {match.group(2)}:
                    if not is_valid:
                        prolog.assertz(f'female({match.group(1)})')
                        prolog.assertz(f'parent_of({match.group(2)}, {match.group(1)})')
                        # prolog.assertz(f'child_of({match.group(1)}, {match.group(2)})')

                        children = list(prolog.query(f'child_of(X, {match.group(2)})'))
                        if len(children) > 0:
                            for c in children:
                                x_value = c['X']
                                prolog.assertz(f'sister_of({match.group(1)}, {x_value})')
                                prolog.assertz(f'sibling_of({match.group(1)}, {x_value})')
                        print("Bot: OK! I learned something.")
                    elif bool(list(prolog.query(f'female({match.group(1)})'))):
                        # prolog.assertz(f'sister_of({match.group(1)}, {match.group(2)})')
                        prolog.assertz(f'parent_of({match.group(2)}, {match.group(1)})')
                        children = list(prolog.query(f'child_of(X, {match.group(2)})'))
                        if len(children) > 0:
                            for c in children:
                                x_value = c['X']
                                prolog.assertz(f'sister_of({match.group(1)}, {x_value})')
                                prolog.assertz(f'sibling_of({match.group(1)}, {x_value})')
                        # prolog.assertz(f'child_of({match.group(1)}, {match.group(2)})')
                        # need ba iadd ung like what if may ibang child ung parent, sasabihin ba na sibs sila
                        print("Bot: OK! I learned something.")
                    else:
                        print("Bot: That's impossible!")

                else:
                    print("Bot: That's impossible!")

            elif i == 6:
                #print("uncle")

                val1 = bool(list(prolog.query(brother)))
                val2 = bool(list(prolog.query(father)))
                val3 = bool(list(prolog.query(son)))
                val4 = bool(list(prolog.query(grandfather)))
                val5 = bool(list(prolog.query(child)))
                val6 = bool(list(prolog.query(parents)))

                is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                            bool(list(prolog.query(f'male({match.group(1)})'))))

                if not val1 and not val2 and not val3 and not val4 and not val5 \
                        and not val6 and {match.group(1)} != {match.group(2)}:
                    sibs = list(prolog.query(f'sibling_of({match.group(1)}, X)'))
                    parent = list(prolog.query(f'parent_of(X, {match.group(2)})'))
                    if not is_valid:
                        if len(parent) < 2:
                            prolog.assertz(f'male({match.group(1)})')
                            prolog.assertz(f'uncle_of({match.group(1)}, {match.group(2)})')
                            print("Bot: OK! I learned something.")
                        else:  # if len(parent) == 2
                            for p in parent:
                                for s in sibs:
                                    if s == p:
                                        prolog.assertz(f'male({match.group(1)})')
                                        prolog.assertz(f'uncle_of({match.group(1)}, {match.group(2)})')
                                        print("Bot: OK! I learned something.")
                                    else:
                                        print("Bot: That's impossible!")
                    elif bool(list(prolog.query(f'male({match.group(1)})'))):
                        if len(parent) < 2:
                            #prolog.assertz(f'male({match.group(1)})')
                            prolog.assertz(f'uncle_of({match.group(1)}, {match.group(2)})')
                            print("Bot: OK! I learned something.")
                        else:  # if len(parent) == 2
                            for p in parent:
                                for s in sibs:
                                    if s == p:
                                        #prolog.assertz(f'male({match.group(1)})')
                                        prolog.assertz(f'uncle_of({match.group(1)}, {match.group(2)})')
                                        print("Bot: OK! I learned something.")
                                    else:
                                        print("Bot: That's impossible!")

                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")
            elif i == 7:
                #print("brother")
                # prolog.assertz(f'brother_of({match.group(1)}, {match.group(2)})')
                # prolog.assertz(f'sibling_of({match.group(1)}, {match.group(2)})')

                is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                            bool(list(prolog.query(f'male({match.group(1)})'))))

                val1 = bool(list(prolog.query(grandfather)))
                val2 = bool(list(prolog.query(father)))
                val3 = bool(list(prolog.query(parents)))
                val4 = bool(list(prolog.query(son)))
                val5 = bool(list(prolog.query(uncle)))

                if not val1 and not val2 and not val3 and not val4 and not val5\
                        and {match.group(1)} != {match.group(2)}:
                    if not is_valid:
                        prolog.assertz(f'male({match.group(1)})')
                        prolog.assertz(f'sibling_of({match.group(1)}, {match.group(2)})')
                        prolog.assertz(f'sibling_of({match.group(2)}, {match.group(1)})')
                        sibs = list(prolog.query(f'sibling_of(X,{match.group(1)})'))
                        if len(sibs) > 0:
                            for s in sibs:
                                X_val = s['X']
                                prolog.assertz(f'brother_of({match.group(1)},{X_val})')
                        print("Bot: OK! I learned something.")
                    elif bool(list(prolog.query(f'male({match.group(1)})'))):
                        prolog.assertz(f'sibling_of({match.group(1)}, {match.group(2)})')
                        prolog.assertz(f'sibling_of({match.group(2)}, {match.group(1)})')
                        sibs = list(prolog.query(f'sibling_of(X,{match.group(1)})'))
                        if len(sibs) > 0:
                            for s in sibs:
                                X_val = s['X']
                                prolog.assertz(f'brother_of({match.group(1)},{X_val})')
                        print("Bot: OK! I learned something.")
                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")

            elif i == 8:
                #print("father")


                parent = list(prolog.query(f'father_of(X,{match.group(2)})'))
                if len(parent) == 0:

                    is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                                bool(list(prolog.query(f'male({match.group(1)})'))))

                    val1 = bool(list(prolog.query(brother)))
                    val2 = bool(list(prolog.query(grandfather)))
                    val6= bool(list(prolog.query(f'grandfather_of({match.group(2)}, {match.group(1)})')))
                    val3 = bool(list(prolog.query(child)))
                    val4 = bool(list(prolog.query(son)))
                    val5 = bool(list(prolog.query(uncle)))

                    if not val1 and not val2 and not val3 and not val4 and not val5 and not val6\
                        and {match.group(1)} != {match.group(2)}:
                        if not is_valid:
                            prolog.assertz(f'male({match.group(1)})')
                            prolog.assertz(f'parent_of({match.group(1)}, {match.group(2)})')
                            prolog.assertz(f'child_of({match.group(2)}, {match.group(1)})')
                            print("Bot: OK! I learned something.")
                        elif bool(list(prolog.query(f'male({match.group(1)})'))):
                            prolog.assertz(f'parent_of({match.group(1)}, {match.group(2)})')
                            prolog.assertz(f'child_of({match.group(2)}, {match.group(1)})')
                            print("Bot: OK! I learned something.")
                        else:
                            print("Bot: That's impossible!")
                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")

            elif i == 9:
                #print("parents")
                count1 = 0
                count2 = 0
                parent = list(prolog.query(f'parent_of(X,{match.group(3)})'))

                if len(parent) == 0:
                    prolog.assertz(f'parent_of({match.group(1)}, {match.group(3)})')
                    prolog.assertz(f'parent_of({match.group(2)}, {match.group(3)})')
                    print("Bot: OK! I learned something.")
                else:
                    for p in parent:
                        xval = p['X']
                        string = f'{match.group(1)}'
                        string2 = f'{match.group(2)}'
                        a = f'{xval}'
                        if a == string:
                            count1 = 1
                        if a == string2:
                            count2 = 1

                    if ((count1 == 1 or count2 == 1) and len(parent) == 1) or ((count1 == 1 and count2 == 1) and len(parent) == 2):
                        print("Bot: OK! I learned something.")

                        if ((count1 == 1 or count2 == 1) and len(parent) == 1):
                            if count1 == 1:
                                prolog.assertz(f'parent_of({match.group(2)}, {match.group(3)})')
                            elif count2 == 1:
                                prolog.assertz(f'parent_of({match.group(1)}, {match.group(3)})')
                    else:
                        print("Bot: That's impossible!")

            elif i == 10:
                #print("grandfather")

                grandfathers = list(prolog.query(f'grandfather_of(X, {match.group(2)})'))

                if len(grandfathers) < 2:
                    val1 = bool(list(prolog.query(son)))
                    val2 = bool(list(prolog.query(father)))
                    val3 = bool(list(prolog.query(child)))
                    val4 = bool(list(prolog.query(uncle)))
                    val7 = bool(list(prolog.query(f'uncle_of({match.group(2)}, {match.group(1)})')))
                    val5 = bool(list(prolog.query(brother)))
                    val6 = bool(list(prolog.query(parents)))

                    is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                                bool(list(prolog.query(f'male({match.group(1)})'))))

                    if not val1 and not val2 and not val3 and not val4 and not val5 \
                            and not val6 and not val7 and {match.group(1)} != {match.group(2)}:
                        kids = list(prolog.query(f'child_of(X, {match.group(1)})'))
                        parent = list(prolog.query(f'parent_of(X, {match.group(2)})'))
                        if not is_valid:
                            if len(parent) < 2:
                                prolog.assertz(f'male({match.group(1)})')
                                prolog.assertz(f'grandfather_of({match.group(1)}, {match.group(2)})')
                                print("Bot: OK! I learned something.")
                            else:  # if len(parent) == 2
                                for p in parent:
                                    for k in kids:
                                        if k == p:
                                            prolog.assertz(f'male({match.group(1)})')
                                            prolog.assertz(f'grandfather_of({match.group(1)}, {match.group(2)})')
                                            print("Bot: OK! I learned something.")
                                        else:
                                            print("Bot: That's impossible!")
                        elif bool(list(prolog.query(f'male({match.group(1)})'))):
                            if len(parent) < 2:
                                # prolog.assertz(f'male({match.group(1)})')
                                prolog.assertz(f'grandfather_of({match.group(1)}, {match.group(2)})')
                                print("Bot: OK! I learned something.")
                            else:  # if len(parent) == 2
                                for p in parent:
                                    for k in kids:
                                        if k == p:
                                            # prolog.assertz(f'male({match.group(1)})')
                                            prolog.assertz(f'grandfather_of({match.group(1)}, {match.group(2)})')
                                            print("Bot: OK! I learned something.")
                                        else:
                                            print("Bot: That's impossible!")

                        else:
                            print("Bot: That's impossible!")
                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")

            elif i == 11:
                children_string = match.group(1)
                parent = match.group(2)

                children = [child.strip() for child in re.split(r',\s*|\s+and\s*|\s+', children_string) if
                            child.lower() != 'and']

                is_valid = False
                if parent not in children:
                    if len(set(children)) == len(children):
                        for child in children:
                            prolog.assertz(f'child_of(\'{child}\', \'{parent}\')')
                        is_valid = True

                if is_valid:
                    print("Bot: OK! I learned something.")
                else:
                    print("Bot: That's impossible!")

            elif i == 12:
                #print("son")
                is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                            bool(list(prolog.query(f'male({match.group(1)})'))))

                val1 = bool(list(prolog.query(brother)))
                val2 = bool(list(prolog.query(father)))
                val3 = bool(list(prolog.query(parents)))
                val4 = bool(list(prolog.query(grandfather)))
                val5 = bool(list(prolog.query(uncle)))

                if not val1 and not val2 and not val3 and not val4 and not val5 \
                        and {match.group(1)} != {match.group(2)}:
                    if not is_valid:
                        prolog.assertz(f'male({match.group(1)})')
                        prolog.assertz(f'parent_of({match.group(2)}, {match.group(1)})')

                        children = list(prolog.query(f'child_of(X, {match.group(2)})'))
                        if len(children) > 0:
                            for c in children:
                                x_value = c['X']
                                prolog.assertz(f'brother_of({match.group(1)}, {x_value})')
                                prolog.assertz(f'sibling_of({match.group(1)}, {x_value})')
                        # prolog.assertz(f'child_of({match.group(1)}, {match.group(2)})')
                        print("Bot: OK! I learned something.")

                    elif bool(list(prolog.query(f'male({match.group(1)})'))):
                        # prolog.assertz(f'sister_of({match.group(1)}, {match.group(2)})')
                        prolog.assertz(f'parent_of({match.group(2)}, {match.group(1)})')
                        children = list(prolog.query(f'child_of(X, {match.group(2)})'))
                        if len(children) > 0:
                            for c in children:
                                x_value = c['X']
                                prolog.assertz(f'brother_of({match.group(1)}, {x_value})')
                                prolog.assertz(f'sibling_of({match.group(1)}, {x_value})')
                        # prolog.assertz(f'child_of({match.group(1)}, {match.group(2)})')
                        # need ba iadd ung like what if may ibang child ung parent, sasabihin ba na sibs sila
                        print("Bot: OK! I learned something.")
                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")

            elif i == 13:
                #("aunt")

                val1 = bool(list(prolog.query(daughter)))
                val2 = bool(list(prolog.query(mother)))
                val3 = bool(list(prolog.query(child)))
                val4 = bool(list(prolog.query(grandmother)))
                val5 = bool(list(prolog.query(sister)))
                val6 = bool(list(prolog.query(parents)))

                is_valid = (bool(list(prolog.query(f'female({match.group(1)})'))) or
                            bool(list(prolog.query(f'male({match.group(1)})'))))

                if not val1 and not val2 and not val3 and not val4 and not val5 \
                        and not val6 and {match.group(1)} != {match.group(2)}:
                    sibs = list(prolog.query(f'sibling_of({match.group(1)}, X)'))
                    parent = list(prolog.query(f'parent_of(X, {match.group(2)})'))
                    if not is_valid:
                        if len(parent) < 2:
                            prolog.assertz(f'female({match.group(1)})')
                            prolog.assertz(f'aunt_of({match.group(1)}, {match.group(2)})')
                            print("Bot: OK! I learned something.")
                        else:  # if len(parent) == 2
                            for p in parent:
                                for s in sibs:
                                    if s == p:
                                        prolog.assertz(f'female({match.group(1)})')
                                        prolog.assertz(f'aunt_of({match.group(1)}, {match.group(2)})')
                                        print("Bot: OK! I learned something.")
                                    else:
                                        print("Bot: That's impossible!")
                    elif bool(list(prolog.query(f'female({match.group(1)})'))):
                        if len(parent) < 2:
                            # prolog.assertz(f'male({match.group(1)})')
                            prolog.assertz(f'aunt_of({match.group(1)}, {match.group(2)})')
                            print("Bot: OK! I learned something.")
                        else:  # if len(parent) == 2
                            for p in parent:
                                for s in sibs:
                                    if s == p:
                                        # prolog.assertz(f'male({match.group(1)})')
                                        prolog.assertz(f'aunt_of({match.group(1)}, {match.group(2)})')
                                        print("Bot: OK! I learned something.")
                                    else:
                                        print("Bot: That's impossible!")

                    else:
                        print("Bot: That's impossible!")
                else:
                    print("Bot: That's impossible!")


            break
        i += 1
    else:
        print("Bot: I don't understand. Please use one of the recognized formats.")


    # return "I don't understand. Please use one of the recognized formats."


def chatbot():
    print("Welcome to the Family Relations Chatbot. Ask me about family relationships!")

    while True:
        user_input = input("You: ")
        user_input = user_input.lower()

        if user_input in ["quit", "exit"]:
            print("Goodbye!")
            break
        elif user_input[len(user_input)-1] == "?":
            check_knowledge_base(user_input)
        else:
            process_input(user_input)



if __name__ == "__main__":
    chatbot()
