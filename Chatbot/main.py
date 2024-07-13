from pyswip import Prolog
import re

prolog = Prolog()
prolog.consult("rules.pl")

statements = [r"(\w+) and (\w+) are siblings.", r"(\w+) is a sister of (\w+).", r"(\w+) is the mother of (\w+).",
              r"(\w+) is a grandmother of (\w+).", r"(\w+) is a child of (\w+).", r"(\w+) is a daughter of (\w+).",
              r"(\w+) is an uncle of (\w+).", r"(\w+) is a brother of (\w+).", r"(\w+) is the father of (\w+).",
              r"(\w+) and (\w+) are the parents of (\w+).", r"(\w+) is a grandfather of (\w+).",
              r"(\w+), (\w+) and (\w+) are children of (\w+).", r"(\w+) is a son of (\w+).", r"(\w+) is an aunt of (\w+)."]
questions = [r"are (\w+) and (\w+) siblings?", r"is (\w+) a sister of (\w+)?", r"is (\w+) a brother of (\w+)?",
             r"is (\w+) the mother of (\w+)?", r"is (\w+) the father of (\w+)?",
             r"are (\w+) and (\w+) the parents of (\w+)?", r"is (\w+) a grandmother of (\w+)?",
             r"is (\w+) a daughter of (\w+)?", r"is (\w+) a son of (\w+)?", r"is (\w+) a child of (\w+)?",
             r"are (\w+), (\w+) and (\w+) children of (\w+)?", r"is (\w+) an uncle of (\w+)?",
             r"who are the siblings of (\w+)?", r"who are the sisters of (\w+)?", r"who are the brothers of (\w+)?",
             r"who is the mother of (\w+)?", r"who is the father of (\w+)?", r"who are the parents of (\w+)?",
             r"is (\w+) a grandfather of (\w+)?", r"who are the daughters of (\w+)?", r"who are the sons of (\w+)?",
             r"who are the children of (\w+)?", r"is (\w+) an aunt of (\w+)?", r"are (\w+) and (\w+) relatives?"]

#input part
def chatbot():
    print("Welcome to the Family Tree Chatbot. Ask me about family relationships!")
    while True:
        user_input = input("You: ")
        if user_input.lower() in ["quit", "exit"]:
            print("Goodbye!")
            break
        response = process_input(user_input)
        print("Bot:", response)

if

prolog.assertz()


#list(prolog.query(father_of(mark, Y)) --> returns a list of all children ba ni mark