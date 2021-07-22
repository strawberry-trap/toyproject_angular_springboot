import { Injectable } from '@angular/core';
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpinterceptorService implements HttpInterceptor{

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (req) {
      console.log('intercept request' + JSON.stringify(req));
    }

    // post
    if (req.method.toLowerCase() === 'post') {

    }
    // get
    else if (req.method.toLowerCase() === 'get') {

    }
    // if body exists
    if (req.body){
      // do something
    }
    return next.handle(req);
  }

  interceptExample(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    // check successfully intercepted or not
    console.log("intercepted request : " + req);

    // req: HttpRequest is immutable(read-only), so if I want to modify the request, I should use clone() method.
    req = req.clone({
      headers: req.headers.set('Content-Type', 'application/json')
    });

    // can use headers.append(), note that append always adds the header even if the header already exists.
    // in this case, use below syntax
    if(!req.headers.has('Content-Type')) {
      req = req.clone({
        headers: req.headers.set('Content-Type', 'application/json')
      });
    }

    // or, add multiple headers at once
    req = req.clone({
      setHeaders: {"X-man": "Wolverine", "Marvel": "superman"}
    });

    // get current value of the header
    req.headers.get('Accept');

    // delete existing header
    req = req.clone({
      headers : req.headers.delete('Content-Type', 'application/json')
    });

    // sample usage of adding token in the header
    const token: String = "sample-token";
    if (token) {
      req = req.clone({
        headers: req.headers.set('Authorization', token.toString())
      });
    }

    return next.handle(req);
  }

  interceptAndChecktime(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    req = req.clone({
      headers: req.headers.set('Content-Type', 'application/json')
    });

    const started = Date.now();

    // ** many tutorials used next.handle(req).do() method, but it doesn't exist anymore (or is not imported)
    // hence I used subscribe, since this method returns an Observable instance. Should check if it works as I intended.
    next.handle(req).subscribe(event => {

      // log next handler's event.
      console.log("an event caught in interceptor(event type doesn't matter) : " + event);

      const elapsed = Date.now() - started;
      console.log(`Request for ${req.urlWithParams} took ${elapsed} ms.`);

      if (event instanceof HttpResponse) {
        console.log(`HttpResponse type event received in http-interceptor.`);

        // process logic with the response, if I want to
      }
    }, error => {
      if( error instanceof HttpErrorResponse) {
        console.log("HttpErrorResponse occurred, error status is : " + error.status);

        // ** here, check if the status really comes in 'number' type
        if (error.status === 401) {
          // 401 : token expired (unauthorized)
          // go back to login template or show a modal
        }
      }
    });

    return next.handle(req);
  }


}
