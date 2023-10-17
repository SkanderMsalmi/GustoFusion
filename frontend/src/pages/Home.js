import React from "react";
import AboutSection from "../components/common/AboutSection";
import WhyUs from "../components/common/WhyUs";
import Menu from "../components/common/Menu";
import SpecialsSections from "../components/common/SpecialsSections";
import EventSections from "../components/common/EventSections";
import BookTableSection from "../components/common/BookTableSection";
import Testimonials from "../components/common/Testimonials";
import GallerySection from "../components/common/GallerySection";
import ChefSection from "../components/common/ChefSection";
import ContactSections from "../components/common/ContactSections";
import HeroSection from "../components/common/HeroSection";

function Home() {
  return (
    <div>
      <HeroSection />
      <AboutSection />
      <WhyUs />
      <Menu />
      <SpecialsSections />
      <EventSections />
      <BookTableSection />
      <Testimonials />
      <GallerySection />
      <ChefSection />
      <ContactSections />
    </div>
  );
}

export default Home;
