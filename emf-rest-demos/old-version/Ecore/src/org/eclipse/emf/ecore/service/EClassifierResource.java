
package org.eclipse.emf.ecore.service;

import java.util.List;

import javax.ws.rs.*;

import org.eclipse.emf.ecore.*;

public class EClassifierResource{

    private org.eclipse.emf.ecore.EClassifier instance;
    
    public EClassifierResource(org.eclipse.emf.ecore.EClassifier instance){
    	this.instance = instance;
    }

	@GET
	public org.eclipse.emf.ecore.EClassifier getEClassifier(){
		return instance;
	}
		
	@PUT
	public void updateEClassifier(org.eclipse.emf.ecore.EClassifier object){
		
	}

   @Path("eAnnotations/{id}")
   public org.eclipse.emf.ecore.service.EAnnotationResource getResourceEAnnotations
   (@PathParam("id") String id)
   {
      return new org.eclipse.emf.ecore.service.EAnnotationResource(webmapi.service.IdentificationResolver.findEAnnotationById(instance.getEAnnotations(),id));   
   }  
		 // REF eAnnotations
   @GET
   @Path("eAnnotations")
   public java.util.List<org.eclipse.emf.ecore.EAnnotation> getEAnnotations(@QueryParam("index") @DefaultValue("-1") int index)
   {
     if(index==-1){
      return instance.getEAnnotations();
     } else {
      return java.util.Collections.singletonList(instance.getEAnnotations().get(index));
     }
          
   }
   @POST
   @Path("eAnnotations")
   public void addEAnnotations
   (org.eclipse.emf.ecore.EAnnotation obj
      , @DefaultValue("-1") @QueryParam("index") int index
   )
   {
     instance.getEAnnotations().add(obj);
   }
  
   @Path("ePackage")
   public org.eclipse.emf.ecore.service.EPackageResource getResourceEPackage()
   {
      return new org.eclipse.emf.ecore.service.EPackageResource(instance.getEPackage());
   }    
		 // REF ePackage
   @Path("eTypeParameters/{id}")
   public org.eclipse.emf.ecore.service.ETypeParameterResource getResourceETypeParameters
   (@PathParam("id") String id)
   {
      return new org.eclipse.emf.ecore.service.ETypeParameterResource(webmapi.service.IdentificationResolver.findETypeParameterById(instance.getETypeParameters(),id));   
   }  
		 // REF eTypeParameters
   @GET
   @Path("eTypeParameters")
   public java.util.List<org.eclipse.emf.ecore.ETypeParameter> getETypeParameters(@QueryParam("index") @DefaultValue("-1") int index)
   {
     if(index==-1){
      return instance.getETypeParameters();
     } else {
      return java.util.Collections.singletonList(instance.getETypeParameters().get(index));
     }
          
   }
   @POST
   @Path("eTypeParameters")
   public void addETypeParameters
   (org.eclipse.emf.ecore.ETypeParameter obj
      , @DefaultValue("-1") @QueryParam("index") int index
   )
   {
     instance.getETypeParameters().add(obj);
   }
	
}

