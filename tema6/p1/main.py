class ContactList(list):
    def search(self, name):
        matching_contacts = []
        for contact in self:
            if name in contact.name:
                matching_contacts.append(contact)
        return matching_contacts


class Contact:
    def __init__(self, name, email):  # constructor
        self.name = name
        self.email = email

    # echivalentul supraincarcarii operator<< din c++
    def __repr__(self):
        return "Contact({}, {})".format(self.name, self.email)


class Agenda:
    all_contacts = ContactList()
    def add_contact(self, contact):
        self.all_contacts.append(contact)
    def print_agenda(self):
        for contact in self.all_contacts:
            print(contact)


class Friend(Contact):
    def __init__(self, name, email, phone):
        super().__init__(name, email)
        self.phone = phone
    def __repr__(self):
        return "Friend({}, {}, {})".format(self.name, self.email, self.phone)


class FriendList:
    friendlist = []
    def getfriendlist(self,agenda):
        for friend in agenda.all_contacts:
            if isinstance(friend,Friend):
                self.friendlist.append(friend)
    def printfriendlist(self):
        for friend in self.friendlist:
            print(friend)
# acest bloc se executa doar cand se apeleaza acest script
# se recomanda folosirea acestui bloc pentru a nu se executa la import
if __name__ == '__main__':
    agenda = Agenda()

    agenda.add_contact(Contact('Ion Popescu','ion_popescu@gmail.com'))
    agenda.add_contact(Friend('Ana', 'ana@', '0123'))
    agenda.add_contact(Friend('Mara', 'mara@', '02122'))
    agenda.print_agenda()
    friend_list = FriendList()
    friend_list.getfriendlist(agenda)
    friend_list.printfriendlist()