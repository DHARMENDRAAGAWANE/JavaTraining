import { MessageService } from "./message.service"

describe("MessageService",() =>{



beforeEach(() => {
  
    //service = new MessageService();

} )

it('should have no message to start',() => {
    let service:MessageService = new MessageService();

    expect(service.messages.length).toBe(0);
})

it('should add a message when it is called',() => {

    let service:MessageService = new MessageService();
service.add('message1');

expect(service.messages.length).toBe(1);


});

it("should remove all the message when it called clear",() => {

    let service:MessageService = new MessageService();
    service.add('message1');

    service.clear();
   
    expect(service.messages.length).toBe(0);

})

})