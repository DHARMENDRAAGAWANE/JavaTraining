import { StrengthPipe } from "./strength.pipe";

describe('StrengthPipe', () => {

it('should display week if strength is 5',() => {

    //arrange
    let pipe = new StrengthPipe();
    
    expect(pipe.transform(5)).toEqual('5 (weak)');


})


it('should display Strong if strength is 10',() => {

    //arrange
    let pipe = new StrengthPipe();
    
    expect(pipe.transform(10)).toEqual('10 (strong)');


})

it('should display unbelievble if strength is unknown',() =>{

    let pipe= new StrengthPipe();
      
     expect(pipe.transform(25)).toEqual('25 (unbelievable)')

})




});