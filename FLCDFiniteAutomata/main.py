def read_file():
    f = open("FA.in", "r")
    data = f.read()
    # states, strings, initial state, final states, transformations
    transitions = []
    ok = 0
    for line in data.splitlines():
        if ok == 0:
            states = line.split(',')
            ok += 1
            pass
        elif ok == 1:
            alphabet = line.split(',')
            ok += 1
            pass
        elif ok == 2:
            initial_state = line
            ok += 1
            pass
        elif ok == 3:
            final_possible_states = line.split(',')
            ok += 1
            pass
        else:
            transitions.append(line.split('-'))
            pass
        pass
    return states, alphabet, initial_state, final_possible_states, transitions


def print_menu():
    print("1: Print the set of states\n")
    print("2: Print the alphabet\n")
    print("3: Print the transitions\n")
    print("4: Print the initial state\n")
    print("5: Print the set of final states\n")
    print("6: Check validity of string\n")
    pass


def check_string(states, alphabet, initial_state, final_possible_states, transitions):
    current_state = initial_state
    for letter in alphabet:
        print(current_state + ", " + letter)
        for transition in transitions:
            if transition[0] == current_state and transition[1] == letter:
                current_state = transition[2]
                break
    print(current_state)
    if current_state in final_possible_states:
        print("The alphabet is correct\n")
    else:
        print("The alphabet is not correct\n")
    pass


if __name__ == '__main__':
    states, alphabet, initial_state, final_possible_states, transitions = read_file()
    while 1:
        print_menu()
        option = input()
        if option == "1":
            print(states)
        elif option == "2":
            print(alphabet)
        elif option == "3":
            print(transitions)
        elif option == "4":
            print(initial_state)
        elif option == "5":
            print(final_possible_states)
        elif option == "6":
            check_string(states, alphabet, initial_state, final_possible_states, transitions)
        elif option == "0":
            break
pass
