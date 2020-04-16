import { ComponentFixture, TestBed } from "@angular/core/testing"
import { HeroesComponent } from "./heroes.component"
import { HeroComponent } from "../hero/hero.component";
import {Component} from "@angular/core"
import {Input} from "@angular/core"
import { NO_ERRORS_SCHEMA } from "@angular/core";
import { HeroService } from "../hero.service"; 
import {By} from "@angular/platform-browser";
import {Hero} from "../hero";
import {of} from "rxjs";
import { Directive} from "@angular/core";

@Directive({
selector: '[routerLink]',
host: { '(click)' : 'onClick()'}


})
export class RouterLinkDirectiveStub {
   @Input('routerLink') linkParams: any;
   navigatedTo: any= null;

   onClick(){

    this.navigatedTo = this.linkParams
   }
     
}


describe("HeroesComponent (Deep Test) ", () => {

let fixture: ComponentFixture<HeroesComponent>;
let mockHeroService;
let HEROES;




beforeEach(() =>{

    HEROES = [
        {id:1, name: 'SpiderDude' , strength: 8},
        {id:2, name: 'Wonderful Women', strength: 24},
        {id:3, name: 'SuperDude', strength:55 }
   ]

 mockHeroService =jasmine.createSpyObj(['getHeroes','addHero','deleteHero']);
  TestBed.configureTestingModule({
   declarations: [HeroesComponent,HeroComponent,RouterLinkDirectiveStub],
   providers: [{
       provide: HeroService, useValue: mockHeroService}
   ],
   //schemas: [NO_ERRORS_SCHEMA]

  })
  fixture = TestBed.createComponent(HeroesComponent);
 

});




    it("should render each hero as a HeroComponet" ,() => {
        mockHeroService.getHeroes.and.returnValue(of(HEROES));
        // run ngOnInit
        fixture.detectChanges();

const heroComponentDEs = fixture.debugElement.queryAll(By.directive(HeroComponent));
        expect(heroComponentDEs.length).toEqual(3);
       //  expect(heroComponentDEs[0].componentInstance.hero.name).toEqual("SpiderDude");

    for(let i; i< heroComponentDEs.length;i++){
           expect(heroComponentDEs[i].componentInstance.hero.name).toEqual(HEROES[i]);
            
        } 
        
  });


  it(`should call heroservice.deleteHero when the Hero component's delete button is clicked`, ()=>{
      spyOn(fixture.componentInstance,"delete")
     mockHeroService.getHeroes.and.returnValue(of(HEROES));
     fixture.detectChanges();

     const heroComponents = fixture.debugElement.queryAll(By.directive(HeroComponent));
     
     for(let i=0; i<heroComponents.length;i++){
     heroComponents[i].query(By.css('button'))
     .triggerEventHandler('click',{stopPropagation: () => {}});
    //(<HeroComponent> heroComponents[i].componentInstance).delete.emit(undefined);
    //heroComponents[i].triggerEventHandler('delete',null);
    expect (fixture.componentInstance.delete).toHaveBeenCalledWith(HEROES[i]) //callled with correct parameter
     }

  });

  it('should add a new hero to hero list when the add button is cliked', () => {
 mockHeroService.getHeroes.and.returnValue(of(HEROES));
 fixture.detectChanges();
 const name = "MR. Anshu";

 mockHeroService.addHero.and.returnValue(of({id: 5,name: name, strength: 4}));

 const inputElement = fixture.debugElement.query(By.css('input')).nativeElement;
 const addButton = fixture.debugElement.query(By.css('button')).nativeElement;
 inputElement.value = name;
 addButton.click();
 //addButton.triggerEventHandler('click',null);
 fixture.detectChanges();

 const heroText=fixture.debugElement.query(By.css('ul')).nativeElement.textContent
 expect(heroText).toContain(name);
  });
  
  it('should have the correct route for the first hero',() => {
    mockHeroService.getHeroes.and.returnValue(of(HEROES));
    fixture.detectChanges();

   const heroComponents = fixture.debugElement.queryAll(By.directive(HeroComponent));

   let routerLink = heroComponents[0].query(By.directive(RouterLinkDirectiveStub))
            .injector.get(RouterLinkDirectiveStub);
  heroComponents[0].query(By.css('a'))
  .triggerEventHandler('click',null);
  

 expect(routerLink.navigatedTo).toBe('/detail/1');

  });


});