import { TestBed, ComponentFixture } from "@angular/core/testing"
import { HeroDetailComponent } from "./hero-detail.component";
import {Location } from "@angular/common"
import { ActivatedRoute } from "@angular/router";
import { HeroService } from "../hero.service";
import {of} from 'rxjs';
import { FormsModule } from "@angular/forms";
describe('Hero-detail' , () =>{

    let fixture:ComponentFixture<HeroDetailComponent>;
    let mockActivatedRoute;
    let mockHeroService; 
    let mockLocation;

    beforeEach(() =>{
         mockActivatedRoute = {

            snapshot: { paramMap: { get: () => {return '3';}}}
         }
         mockHeroService = jasmine.createSpyObj(['getHero','updateHero']);
         mockLocation = jasmine.createSpyObj(['back']);

        TestBed.configureTestingModule({
            imports: [FormsModule],
declarations: [HeroDetailComponent],
providers: [
  {provide:  ActivatedRoute, useValue: mockActivatedRoute},
  {provide: HeroService,useValue: mockHeroService},
  {provide: Location, useValue: mockLocation}

]

        });

        fixture = TestBed.createComponent(HeroDetailComponent);
        mockHeroService.getHero.and.returnValue(of({id: 3, name: 'SuperDude', strength: 100}));  
    })

    it('should render hero name in h2 tag',() =>{
        fixture.detectChanges();
        expect(fixture.nativeElement.querySelector('h2').textContent).toContain('SUPERDUDE');  //template all uppercase

    });

})